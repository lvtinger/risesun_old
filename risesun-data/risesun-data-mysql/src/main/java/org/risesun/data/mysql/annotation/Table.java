package org.risesun.data.mysql.annotation;

import java.lang.annotation.*;

@Documented
@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String value() default "";
}