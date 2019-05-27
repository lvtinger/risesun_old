package org.risesun.model.document;

import org.risesun.model.algorithm.CachedAlgorithm;

public abstract class CachedDocument extends Document implements CachedAlgorithm<CachedDocument> {
    public abstract String[] calculateDimension(CachedDocument document);
}