package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class AccountServiceAspect {
    @Pointcut("this(com.demo.service.AccountService)")
    public void thisPointcutAccountService(){
    }
    // @Before("thisPointcutAccountService()")
    public void beforeAccountServiceAdvice(JoinPoint joinPoint){
        String clasName=joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s %s method is invoked with before advice in [%s].",
                        clasName,
                        joinPoint.getSignature().getName(), LocalDateTime.now())
        );
    }
}
