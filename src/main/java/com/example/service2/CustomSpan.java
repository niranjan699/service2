package com.example.service2;

import brave.Span;
import brave.Tracer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class CustomSpan {
    @Autowired
    Tracer tracer;

    @Around( "@annotation(ZipkinTrace)" )
    public Object doBasicProfiling( ProceedingJoinPoint pjp) throws Throwable {



        Span    span   = tracer.nextSpan().name("custom-span").start();
         Object retVal = pjp.proceed();

            span.finish();
            return retVal;
    }


}
