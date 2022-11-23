package com.springboot.service;

import org.springframework.stereotype.Service;

@Service
public class DummyService1 {

    public void doSomething(){
        for (int i = 0; i < 10000; i++) {
            // dummy process
        }
        return;
    }

    public void doSomethingElse(){
        for (int i = 0; i < 30000; i++) {
            // dummy process
        }
        return;
    }
}
