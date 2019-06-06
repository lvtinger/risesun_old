package org.risesun.data.mysql.annotation;

public @interface CacheVersion {
    public String value() default "";
}