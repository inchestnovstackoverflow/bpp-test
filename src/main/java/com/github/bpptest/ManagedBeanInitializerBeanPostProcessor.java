package com.github.bpptest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ManagedBeanInitializerBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {

    private ManagedComponent managedComponent;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        try {
            managedComponent = applicationContext.getBean(ManagedComponent.class);
        } catch (BeansException e) {
            // ignore
        }
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Object obj = BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);

        if (obj instanceof AutowireComponent && managedComponent != null) {
            managedComponent.addAutowireComponent((AutowireComponent) obj);
        }

        return obj;
    }
}
