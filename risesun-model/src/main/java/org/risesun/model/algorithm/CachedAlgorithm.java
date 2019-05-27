package org.risesun.model.algorithm;

import org.risesun.model.document.Document;

/**
 * 缓存维度算法
 *
 * @param <T>
 */
public interface CachedAlgorithm<T extends Document> {
    String[] calculateDimension(T document);
}