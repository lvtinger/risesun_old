package org.risesun.data.mysql.meta.factory;

import org.risesun.data.mysql.meta.bean.Metadata;

import java.io.Serializable;

public interface MetadataFactory {
    Metadata generate(Class<? extends Serializable> type);
}