package org.risesun.model.document;

import org.risesun.model.algorithm.CachedAlgorithm;

import java.io.Serializable;

public abstract class CachedDocument<ID extends Serializable> extends Document<ID> implements CachedAlgorithm<CachedDocument<ID>> {
    public abstract String[] calculateDimension(CachedDocument document);
}