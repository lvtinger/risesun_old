package org.risesun.data.core.repository;

import java.io.Serializable;

public abstract class AbstractRepository<T extends Serializable, D extends Serializable> {
    protected abstract String calculateSource(T document);

    protected abstract String calculateBase(T document);

    protected abstract String calculateTable(T document);
}