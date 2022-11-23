package com.springboot.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    // advice (pointcut expression)
    //PointCut types - execution, args, within
    //Advices - Before, After, AfterReturning, AfterThrowing, Around

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
