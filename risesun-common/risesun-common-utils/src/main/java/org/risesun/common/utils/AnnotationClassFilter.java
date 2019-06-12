package org.risesun.common.utils;

import java.lang.annotation.Annotation;

public class AnnotationClassFilter implements ClassFilter {

    private Class<? extends Annotation> annotation;

    public AnnotationClassFilter(Class<? extends Annotation> annotation) {
        this.annotation = annotation;
    }

    @Override
    public boolean math(Class<?> type) {
        if (null == type) {
            return false;
        }

        Annotation annotation = type.getDeclaredAnnotation(this.annotation);
        return annotation != null;
    }
}
