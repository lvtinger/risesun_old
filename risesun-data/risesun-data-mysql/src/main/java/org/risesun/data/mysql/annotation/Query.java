package org.risesun.data.mysql.annotation;

public @interface Query {
    String value();

    boolean secondary() default false;
}