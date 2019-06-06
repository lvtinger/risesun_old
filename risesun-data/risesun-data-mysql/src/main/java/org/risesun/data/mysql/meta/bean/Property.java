package org.risesun.data.mysql.meta.bean;

import lombok.Getter;
import lombok.Setter;
import org.risesun.data.mysql.reflection.invoker.Invoker;
import org.risesun.data.mysql.support.DefaultValueGenerator;

@Getter
@Setter
public class Property {

    private boolean isPrimaryKey;
    private String columnName;
    private String propertyName;

    private Class<?> propertyType;

    private Invoker getter;
    private Invoker setter;

    public DefaultValueGenerator generator;
    
}