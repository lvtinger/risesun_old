package org.risesun.data.core;

import java.util.Map;

public abstract class SourceBuilder<T> {
    protected abstract void config(Map<String, Object> config);
}
