package org.risesun.data.mysql.meta.bean;

import lombok.Getter;
import lombok.Setter;
import org.risesun.data.mysql.reflection.invoker.Invoker;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Metadata {
    private Class<?> metadataType;
    private String metadataName;

    private String cacheVersion;

    private String database;
    private String tableName;
    private Property primaryKey;
    private Map<String, String> columnMapping = new HashMap<>();

    private Constructor<?> defaultConstructor;
    private Map<String, Property> properties = new HashMap<>();
    private Map<String, String> propertyMapping = new HashMap<>();
    private Map<String, Invoker> getterInvoker = new HashMap<>();
    private Map<String, Invoker> setterInvoker = new HashMap<>();
    private List<Property> defaultValueProperties = new ArrayList<>();


    public Metadata() {
    }

    public Object getPropertyValue(Object object, String propertyName) {
        try {
            return getterInvoker.get(propertyName).invoke(object, null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public void setPropertyValue(Object object, String propertyName, Object... propertyValue) {
        try {
            this.setterInvoker.get(propertyName).invoke(object, propertyValue);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException();
        }
    }

    public Property getProperty(String propertyName) {
        return this.properties.get(propertyName);
    }
}