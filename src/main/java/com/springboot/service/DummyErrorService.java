package com.springboot.service;

import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DummyErrorService {

    public String occasionalError() throws Exception {
        Random r = new Random();
        String res = "success";
        if(r.nextInt(2) == 0){
            // success
        }else{
            res = "failure";
            throw new Exception();
        }
        return res;
    }
}
