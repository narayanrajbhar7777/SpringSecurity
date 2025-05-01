package com.exceptionshandler.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@Slf4j
@EnableAspectJAutoProxy
public class GeneralAOP {
    private static final Logger log = LoggerFactory.getLogger(GeneralAOP.class);

    @Pointcut("execution(* com.exceptionshandler.controller.*.*(..))")
    public void loginPointCut(){}

    @Before("loginPointCut()")
    public void before(JoinPoint joinPoint){
        log.info("Before: {}", joinPoint.getSignature());
    }
    @After("loginPointCut()")
    public void after(JoinPoint joinPoint){
        log.info("After{}", joinPoint.getSignature());
    }
}
