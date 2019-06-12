package org.risesun.data.mysql.meta.factory;

import org.risesun.data.mysql.meta.bean.Metadata;

public interface MetadataFactory {
    Metadata generate(Class<?> type);
}