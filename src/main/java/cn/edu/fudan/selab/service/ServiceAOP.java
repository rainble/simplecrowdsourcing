package cn.edu.fudan.selab.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

@Aspect
@Service
public class ServiceAOP {
    @Pointcut("execution(* cn.edu.fudan.selab.service.*Service.*(..))")
    public void servicePointcut(){

    }

    @Pointcut("execution(* cn.edu.fudan.selab.controller.*controller.*(..))")
    public void controllerPointcut() {

    }
    @Around("servicePointcut() || controllerPointcut()")
    public Object doAround(ProceedingJoinPoint pjp) {
        Object result = null;
        String methodName = pjp.getSignature().getName();
        try {
            System.out.println("The method [ " + methodName + " ] begins with [ " + Arrays.asList(pjp.getArgs()) + " ] at [ " + new Date() + " ].");
            result = pjp.proceed();
            System.out.println("The method [ " + methodName + " ] ends with [ " + Arrays.asList(pjp.getArgs()) + " ] at [ " + new Date() + " ].");
        } catch (Throwable t) {
            System.out.println("The method [ " + methodName + " ] occurs exception [ " + t + " ] at [ " + new Date() + " ].");
            throw new RuntimeException(t);
        }
        System.out.println("The method [ " + methodName + " ] ends at [ " + new Date() + " ].");
        return result;
    }
}