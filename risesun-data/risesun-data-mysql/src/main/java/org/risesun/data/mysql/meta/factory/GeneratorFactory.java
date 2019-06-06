package org.risesun.data.mysql.meta.factory;

import org.risesun.data.mysql.support.DefaultValueGenerator;

public interface GeneratorFactory {
    DefaultValueGenerator generate(Class<? extends DefaultValueGenerator> type);
}