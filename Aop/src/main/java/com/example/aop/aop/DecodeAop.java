package com.example.aop.aop;

import com.example.aop.dto.user;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    //해당 클래스에 적용
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut(){ }

    @Pointcut("@annotation(com.example.aop.annotaion.Decode)")
    private void enableDecode(){ }

    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint){

        Object[] args = joinPoint.getArgs();
        for(Object arg : args){

            if(arg instanceof user) {
                user user = com.example.aop.dto.user.class.cast(arg);
                String base64Email = user.getEmail();
                String email = new String(Base64.getDecoder().decode(base64Email));
                user.setEmail(email);
                System.out.println(email);
            }

        }
    }

    @AfterReturning(value = "cut() && enableDecode()", returning = "returnobj")
    public void afterReturn(JoinPoint joinPoint, Object returnobj) {
        if (returnobj instanceof user) {

            user user = com.example.aop.dto.user.class.cast(returnobj);
            String email = user.getEmail();
            String base64Email = Base64.getEncoder().encodeToString(email.getBytes());
            user.setEmail(base64Email);
            System.out.println(base64Email);

        }
    }

}
