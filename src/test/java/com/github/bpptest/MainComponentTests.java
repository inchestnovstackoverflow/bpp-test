package com.github.bpptest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MainConfiguration.class)
class MainComponentTests {

    @Autowired
    private MainComponent mainComponent;

    @MockBean
    private ManagedComponent managedComponent;

    @Test
    void contextLoads() {
        mainComponent.foo();
        Mockito.verify(managedComponent).foo();
    }

}
