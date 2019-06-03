package org.risesun.model.document;

import org.risesun.model.algorithm.ShardingAlgorithm;

import java.io.Serializable;

public abstract class ShardingDocument<ID extends Serializable> extends CachedDocument<ID> implements ShardingAlgorithm<ShardingDocument> {

    public abstract String calculateDataSource(ShardingDocument document);

    public abstract String calculateDatabase(ShardingDocument document);

    public abstract String calculateDataTable(ShardingDocument document);
    
}