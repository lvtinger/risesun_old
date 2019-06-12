package org.risesun.data.mysql.context;

import lombok.Getter;
import lombok.Setter;
import org.risesun.common.utils.AnnotationClassFilter;
import org.risesun.common.utils.ClassUtils;
import org.risesun.data.mysql.annotation.Table;
import org.risesun.data.mysql.meta.bean.Metadata;
import org.risesun.data.mysql.meta.factory.GeneralMetadataFactory;
import org.risesun.data.mysql.meta.factory.MetadataFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class DefaultDataContext implements DataContext, BeanFactoryPostProcessor {
    @Getter
    @Setter
    private String[] packages;

    private Map<String, DataSource> datasourceHolder = new HashMap<>();
    private Map<Class<?>, Metadata> metadataHolder = new HashMap<>();


    @Override
    public Metadata getMetadata(Class<?> type) {
        return metadataHolder.get(type);
    }

    @Override
    public Connection getConnection(String name) {
        return null;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        AnnotationClassFilter filter = new AnnotationClassFilter(Table.class);
        Set<Class<?>> classes = ClassUtils.doScan(filter, packages);
        MetadataFactory factory = new GeneralMetadataFactory();
        for (Class<?> type : classes) {
            Metadata metadata = factory.generate(type);
            metadataHolder.put(type, metadata);
        }
    }
}
