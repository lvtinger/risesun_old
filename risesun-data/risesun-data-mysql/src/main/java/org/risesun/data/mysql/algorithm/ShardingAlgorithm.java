package org.risesun.data.mysql.algorithm;

public interface ShardingAlgorithm {
    String calculateBase(Object object);

    String calculateTable(Object object);
}