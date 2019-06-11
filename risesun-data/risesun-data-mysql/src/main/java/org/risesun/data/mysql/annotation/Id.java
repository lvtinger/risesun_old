package org.risesun.data.mysql.annotation;

import org.risesun.data.mysql.enums.PrimaryKeyGenerateMode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Id {
    PrimaryKeyGenerateMode mode() default PrimaryKeyGenerateMode.PROGRAME;
}