package org.risesun.data.mysql;

import org.risesun.data.mysql.meta.bean.Metadata;
import org.springframework.beans.factory.InitializingBean;

import java.util.HashMap;
import java.util.Map;

public class ApplicationDataContext implements InitializingBean {

    private final Map<Class<?>, Metadata> metadataHolder = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
    }

    public Metadata getMetadata(Class<?> type) {
        return metadataHolder.get(type);
    }
}
