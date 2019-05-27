package org.risesun.model.document;

import org.risesun.model.algorithm.CachedAlgorithm;
import org.risesun.model.algorithm.ShardingAlgorithm;

public abstract class ShardingDocument extends Document implements CachedAlgorithm<ShardingDocument>, ShardingAlgorithm<ShardingDocument> {

    public abstract String[] calculateDimension(ShardingDocument document);

    public abstract String calculateDataSource(ShardingDocument document);

    public abstract String calculateDatabase(ShardingDocument document);

    public abstract String calculateDataTable(ShardingDocument document);
}