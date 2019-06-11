package org.risesun.data.mysql.meta.factory;

import org.risesun.common.utils.StringUtils;
import org.risesun.data.mysql.annotation.Column;
import org.risesun.data.mysql.annotation.DefaultValue;
import org.risesun.data.mysql.meta.bean.Property;
import org.risesun.data.mysql.reflection.invoker.MethodInvoker;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GeneralPropertyFactory implements PropertyFactory {

    private GeneralGeneratorFactory generatorFactory = new GeneralGeneratorFactory();

    public Property generate(Field field) {
        Class<?> type = field.getDeclaringClass();
        String name = calculateName(field.getName());
        Method getter = null;
        try {
            getter = type.getDeclaredMethod("get" + name);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException();
        }
        Method setter = null;
        try {
            setter = type.getDeclaredMethod("set" + name, field.getType());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException();
        }

        Property property = new Property();
        property.setPropertyName(field.getName());
        property.setColumnName(field.getName());
        property.setPropertyType(field.getType());

        property.setGetter(new MethodInvoker(getter));
        property.setSetter(new MethodInvoker(setter));

        Column column = field.getDeclaredAnnotation(Column.class);
        if (null != column) {
            String value = column.value();
            if (StringUtils.isEmpty(value)) {
                property.setColumnName(value);
            }
        }

        DefaultValue defaultValue = field.getDeclaredAnnotation(DefaultValue.class);
        if (null != defaultValue) {
            property.setGenerator(generatorFactory.generate(defaultValue.value()));
        }

        return property;
    }

    private String calculateName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
