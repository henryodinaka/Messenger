package com.leo.henry.messenger.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AspectTest {
    @Before("execution(* MessageService.*(..))")
    public void before(JoinPoint jointPoint)
    {
        System.out.println("Before");
        System.out.println(jointPoint.getSignature().getName());
        System.out.println(Arrays.toString(jointPoint.getArgs()));
    }
}
