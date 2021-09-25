package com.github.bpptest;

import org.springframework.stereotype.Component;

@Component
public class EmptyAutowireComponent implements AutowireComponent {

    @Override
    public void invoke() {

    }

}
