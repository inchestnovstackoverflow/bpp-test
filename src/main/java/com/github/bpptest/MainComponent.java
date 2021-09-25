package com.github.bpptest;

import org.springframework.stereotype.Component;

@Component
public class MainComponent {

    private ManagedComponent managedComponent;

    public void setManagedComponent(ManagedComponent managedComponent) {
        this.managedComponent = managedComponent;
    }

    public void foo() {
        managedComponent.foo();
    }

}
