package com.sebastian.boot2;

import java.time.LocalDateTime;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAroundAspect {
    private Log log = LogFactory.getLog(getClass());             
    @Around("execution(* com.sebastian.boot2..*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        LocalDateTime start = LocalDateTime.now();
        Throwable toThrow = null;
        Object returnValue = null;
        try {
            returnValue = joinPoint.proceed();
        } catch(Throwable t) {
            toThrow = t;
        }
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info("clase: " + signature.getDeclaringType().getCanonicalName());
        LocalDateTime stop = LocalDateTime.now();
        log.info("starting: " + start.toString() + " " + joinPoint.getTarget().getClass());        
        log.info("finish: " + stop.toString() + " " + joinPoint.getTarget().getClass());
        log.info("duration: " + stop.minusNanos(start.getNano()).getNano() + " " + joinPoint.getTarget().getClass());
        if (null != toThrow) {
            throw toThrow;
        }
        return returnValue;
    }
}
