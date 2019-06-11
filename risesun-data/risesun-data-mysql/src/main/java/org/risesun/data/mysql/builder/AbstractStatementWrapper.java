package org.risesun.data.mysql.builder;

import org.risesun.data.mysql.meta.bean.Metadata;

public abstract class AbstractStatementWrapper implements StatementWrapper {
    protected Metadata metadata;

    protected AbstractStatementWrapper(Metadata metadata) {
        this.metadata = metadata;
    }
}
