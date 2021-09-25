package com.github.bpptest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MainComponentInitializerBeanPostProcessor implements BeanPostProcessor {

    private ManagedComponent managedComponent;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Object obj = BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);

        if (obj instanceof ManagedComponent) {
            managedComponent = (ManagedComponent) obj;
        }

        return obj;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Object obj = BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);

        if (obj instanceof MainComponent) {
            ((MainComponent) obj).setManagedComponent(managedComponent);
        }

        return obj;
    }
}
