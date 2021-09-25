package com.github.bpptest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManagedComponent implements BeanFactoryPostProcessor {

    private final List<AutowireComponent> autowireComponents = new ArrayList<>();

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // just make sure that this bean created before others
    }

    public void addAutowireComponent(AutowireComponent autowireComponent) {
        autowireComponents.add(autowireComponent);
    }

    public void invokeAll() {
        autowireComponents.forEach(AutowireComponent::invoke);
    }

}
