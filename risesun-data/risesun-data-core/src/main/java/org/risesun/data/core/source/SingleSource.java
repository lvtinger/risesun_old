package org.risesun.data.core.source;

public class SingleSource<T> implements Source<T> {

    private T source;

    public T main() {
        return source;
    }

    public T read() {
        return source;
    }
}
