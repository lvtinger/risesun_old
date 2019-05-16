package org.risesun.data.core.source;

public interface Source<T> {
    T main();
    T read();
}