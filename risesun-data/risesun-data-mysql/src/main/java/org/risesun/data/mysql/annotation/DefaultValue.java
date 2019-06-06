package org.risesun.data.mysql.annotation;

import org.risesun.data.mysql.support.DefaultValueGenerator;

public @interface DefaultValue {
    Class<? extends DefaultValueGenerator> value();
}
