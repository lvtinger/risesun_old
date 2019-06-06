package org.risesun.data.mysql.meta.factory;

import org.risesun.data.mysql.meta.bean.Property;

import java.lang.reflect.Field;

public interface PropertyFactory {
    Property generate(Field field);
}
