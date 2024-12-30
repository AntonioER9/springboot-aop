package com.antonio.course.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class GreetingAspect {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Before("execution(String com.antonio.course.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))")
  private void loggerBefore(JoinPoint joinPoint) {

    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());
    logger.info("Before method: " + method + ", args: " + args);
  }

  @After("execution(String com.antonio.course.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))")
  private void loggerAfter(JoinPoint joinPoint) {

    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());
    logger.info("After method: " + method + ", args: " + args);
  }

  @AfterReturning("execution(String com.antonio.course.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))")
  private void loggerAfterReturning(JoinPoint joinPoint) {

    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());
    logger.info("After Returning method: " + method + ", args: " + args);
  }

  @AfterThrowing("execution(String com.antonio.course.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))")
  private void loggerAfterThrowing(JoinPoint joinPoint) {

    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());
    logger.info("After exception method: " + method + ", args: " + args);
  }

  @Around("execution(String com.antonio.course.springboot.app.aop.springboot_aop.services.*.*(..))")
  public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());

    Object result = null;

    try {
      logger.info("Before method: " + method + ", args: " + args);
      result = joinPoint.proceed();
      logger.info("After method: " + method + ", args: " + args);
      return result;
    } catch (Throwable e) {
      logger.info("After exception method: " + method + ", args: " + args);
      throw e;
    }

  }
}
