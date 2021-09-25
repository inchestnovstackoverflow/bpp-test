package com.github.bpptest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ContextConfiguration(classes = MainConfiguration.class)
class ManagedComponentTests {

    @Autowired
    private ManagedComponent managedComponent;

    @Autowired
    private EmptyAutowireComponent emptyAutowireComponent;

    @Test
    void contextLoads() {
        managedComponent.invokeAll();
        Mockito.verify(emptyAutowireComponent).invoke();
    }

}
