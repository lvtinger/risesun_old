package org.risesun.data.core.repository;

import org.risesun.model.document.CachedDocument;

import java.io.Serializable;

public abstract class CachedRepository<T extends CachedDocument<ID>, ID extends Serializable>
        extends AbstractRepository<T, ID> {

}