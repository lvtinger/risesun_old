package org.risesun.data.core.repository;

import org.risesun.model.document.ShardingDocument;

import java.io.Serializable;

public abstract class ShardingRepository<T extends ShardingDocument<ID>, ID extends Serializable>
        extends CachedRepository<T, ID> {
}
