package org.risesun.data.mysql.meta.factory;

import org.risesun.common.utils.ClassUtils;
import org.risesun.data.mysql.annotation.CacheVersion;
import org.risesun.data.mysql.annotation.Database;
import org.risesun.data.mysql.annotation.Id;
import org.risesun.data.mysql.annotation.Table;
import org.risesun.data.mysql.meta.bean.Metadata;
import org.risesun.data.mysql.meta.bean.PrimaryKey;
import org.risesun.data.mysql.meta.bean.Property;
import org.risesun.data.mysql.support.PropertyFilter;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

public class GeneralMetadataFactory implements MetadataFactory {

    private PropertyFilter filter = new PropertyFilter();
    private PropertyFactory propertyFactory = new GeneralPropertyFactory();

    public Metadata generate(Class<? extends Serializable> type) {
        Metadata metadata = new Metadata();
        metadata.setMetadataType(type);
        database(metadata);
        constructor(metadata);
        properties(metadata);
        cache(metadata);
        return metadata;
    }

    private void database(Metadata metadata) {
        Class<?> type = metadata.getMetadataType();
        Table table = type.getDeclaredAnnotation(Table.class);
        metadata.setTableName(table.value());
        Database database = type.getDeclaredAnnotation(Database.class);
        metadata.setDatabase(database.value());
    }

    private void constructor(Metadata metadata) {
        Class<?> type = metadata.getMetadataType();
        Constructor<?>[] constructors = type.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterTypes().length == 0) {
                int modifiers = constructor.getModifiers();
                if (Modifier.isPublic(modifiers)) {
                    metadata.setDefaultConstructor(constructor);
                    break;
                }
            }
        }

        if (metadata.getDefaultConstructor() == null) {
            throw new RuntimeException();
        }
    }

    private void properties(Metadata metadata) {
        Class<?> type = metadata.getMetadataType();
        List<Field> fields = ClassUtils.scanFields(type, this.filter);
        for (Field field : fields) {
            Property property = propertyFactory.generate(field);
            String propertyName = property.getPropertyName();
            metadata.getProperties().put(propertyName, property);
            metadata.getGetterInvoker().put(propertyName, property.getGetter());
            metadata.getSetterInvoker().put(propertyName, property.getSetter());
            metadata.getPropertyMapping().put(propertyName, property.getColumnName());
            metadata.getColumnMapping().put(property.getColumnName(), propertyName);
            if (property.getGenerator() != null) {
                metadata.getDefaultValueProperties().add(property);
            }

            Id id = field.getDeclaredAnnotation(Id.class);
            if (null != id) {
                PrimaryKey primaryKey = new PrimaryKey();
                primaryKey.setProperty(property);
                primaryKey.setMode(id.mode());
                metadata.setPrimaryKey(primaryKey);
            }
        }
    }

    private void cache(Metadata metadata) {
        Class<?> type = metadata.getMetadataType();
        CacheVersion cacheVersion = type.getDeclaredAnnotation(CacheVersion.class);
        metadata.setCacheVersion(cacheVersion.value());
    }
}