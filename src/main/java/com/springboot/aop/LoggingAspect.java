package com.springboot.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
<<<<<<< HEAD
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
=======
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
>>>>>>> parent of 8334b5a (added time logger with logging database)
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    // advice (pointcut expression)
    //PointCut types - execution, args, within
    //Advices - Before, After, AfterReturning, AfterThrowing, Around

<<<<<<< HEAD
    @Autowired
    TimeLogRepository timeRepo;

    @Pointcut("execution(* com.springboot.controller.DummyController1.*(..))")
    public void allDummyMethods(){};

    @AfterReturning(value = "allDummyMethods()")
    public void reportSuccess(JoinPoint jp){
        Signature sig = jp.getSignature();
        System.out.println("method: \"" + sig.toString() + "\" ran successfully with no errors");
    }

    @AfterThrowing(value = "allDummyMethods()", throwing = "e")
    public void reportFailure(JoinPoint jp, Exception e){
        Signature sig = jp.getSignature();
        System.out.println("method: \"" + sig.toString() + "\" failed with exception: " + e.toString());
    }

=======
>>>>>>> parent of 8334b5a (added time logger with logging database)
    @Before(value = "execution(* com.springboot.controller.StudentController.*(..))")
    public void logSomething(JoinPoint jp){
        Signature signature = jp.getSignature();
        System.out.println("logging called before method " + signature.toString() + " is called");
    }

    @After(value = "execution(* com.springboot.controller.StudentController.*(..))")
    public void logSomething2(JoinPoint jp){
        Signature signature = jp.getSignature();
        System.out.println("logging called after method " + signature.toString() + " is called");
    }

    @Around(value = "execution(* com.springboot.controller.StudentController.*(..))")
    public void testAround(ProceedingJoinPoint jp){
        //System.out.println("logging called before method");
        float start = System.nanoTime();

        try {
            jp.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        float end = System.nanoTime();
        //Signature sig = jp_data.getSignature();

        System.out.println("method executed successfully in " + (end-start) + " nano seconds");
    }

}
