package org.risesun.data.core.repository;

import org.risesun.model.document.Document;

import java.io.Serializable;

public abstract class AbstractRepository<D extends Document<Id>, Id extends Serializable> {
    public abstract Document create(D document);

    public abstract Document update(D document);

    public abstract Document delete(D document);

    public abstract Document getById(Id id);
}