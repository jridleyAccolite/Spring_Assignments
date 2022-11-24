package com.springboot.controller;

import com.springboot.service.DummyErrorService;
import com.springboot.service.DummyService1;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController1 {

    @Autowired
    DummyService1 dService;
    @Autowired
    DummyErrorService eService;

    // throws exception on to the Advice in LoggingAspect
    @GetMapping("possible-error")
    public ResponseEntity<String> attemptMethod() throws Exception{
        // dummy method that calls a service that sometimes fails
        String s = "success";
        try {
            eService.occasionalError();
        }catch(Exception e){
            s = "failure";
            throw e;
        }
        return new ResponseEntity<>(s, HttpStatus.OK);
    }
}
