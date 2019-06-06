package org.risesun.data.mysql.meta.factory;

import org.risesun.data.mysql.support.DefaultValueGenerator;

import java.util.HashMap;
import java.util.Map;

public class GeneralGeneratorFactory implements GeneratorFactory {

    private Map<Class<?>, DefaultValueGenerator> map = new HashMap<>();

    @Override
    public DefaultValueGenerator generate(Class<? extends DefaultValueGenerator> type) {
        if (map.containsKey(type)) {
            return map.get(type);
        }

        try {
            DefaultValueGenerator defaultValueGenerator = type.newInstance();
            map.put(type, defaultValueGenerator);
            return defaultValueGenerator;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
