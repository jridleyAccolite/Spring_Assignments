package com.springboot.aop;

import com.springboot.model.LogEntry;
import com.springboot.repo.TimeLogRepository;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
public class LoggingAspect {
    // advice (pointcut expression)
    //PointCut types - execution, args, within
    //Advices - Before, After, AfterReturning, AfterThrowing, Around

    @Autowired
    TimeLogRepository timeRepo;

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

        // save log info in db
        LogEntry log = new LogEntry();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        log.setDate(LocalDateTime.now().format(dateFormatter));
        log.setName(jp.getSignature().getName());
        log.setTime(LocalDateTime.now().format(timeFormatter));
        log.setDuration((end-start));

        timeRepo.save(log);
    }

}
