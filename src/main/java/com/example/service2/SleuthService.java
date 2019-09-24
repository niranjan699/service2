package com.example.service2;

import brave.Span;
import brave.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class SleuthService {

    private       Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Tracer tracer;
    @Autowired
    public SleuthService(Tracer tracer) {
        this.tracer = tracer;
    }

    public void doSomeWorkSameSpan() throws InterruptedException {
        Thread.sleep(1000L);
        logger.info("Doing some work");
    }



}
