package org.risesun.data.mysql.scanner;

import org.risesun.data.mysql.annotation.Repository;
import org.risesun.data.mysql.proxy.RepositoryFactoryBean;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

public class RepositoryScanner extends ClassPathBeanDefinitionScanner {

    private final static boolean USE_DEFAULT_FILTERS = true;

    public RepositoryScanner(BeanDefinitionRegistry registry) {
        super(registry, USE_DEFAULT_FILTERS);
    }

    @Override
    protected void registerDefaultFilters() {
        this.addIncludeFilter(new AnnotationTypeFilter(Repository.class));
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {

        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);

        for (BeanDefinitionHolder holder : beanDefinitionHolders) {
            GenericBeanDefinition definition = (GenericBeanDefinition) holder.getBeanDefinition();
            definition.getConstructorArgumentValues()
                    .addGenericArgumentValue(definition.getBeanClassName());
            definition.setBeanClass(RepositoryFactoryBean.class);
            this.getRegistry().registerBeanDefinition(holder.getBeanName(), definition);
            definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
        }

        return beanDefinitionHolders;
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface() && beanDefinition.getMetadata().isIndependent();
    }
}