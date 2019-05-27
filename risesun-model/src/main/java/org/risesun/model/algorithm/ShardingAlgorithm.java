package org.risesun.model.algorithm;

import org.risesun.model.document.Document;

/**
 * 数据分片算法
 *
 * @param <T>
 */
public interface ShardingAlgorithm<T extends Document> {
    String calculateDataSource(T document);

    String calculateDatabase(T document);

    String calculateDataTable(T document);
}