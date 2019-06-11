package org.risesun.data.mysql.meta.bean;

import lombok.Getter;
import lombok.Setter;
import org.risesun.data.mysql.reflection.Invoker;
import org.risesun.data.mysql.support.DefaultValueGenerator;
import org.risesun.data.mysql.type.TypeHandler;

@Getter
@Setter
public class Property {

    private boolean isPrimaryKey;
    private String columnName;
    private String propertyName;

    private Class<?> propertyType;
    private TypeHandler<?> typeHandler;

    private Invoker getter;
    private Invoker setter;

    public DefaultValueGenerator generator;

}