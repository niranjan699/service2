package com.example.service2;

import brave.Span;
import brave.Tracer;
import brave.sampler.Sampler;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Service2Application {

    public static void main ( String[] args ) {
        SpringApplication.run( Service2Application.class, args );
    }

        Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
   Tracer tracer;


    @ZipkinTrace
    @RequestMapping(value = "/checked1-out")
    public String checkedOut1() throws InterruptedException {


            Thread.sleep( 3000 );

            return "check in service 2";
    }

    @Autowired
    private SleuthService sleuthService;
    @GetMapping("/same-span")
    public String helloSleuthSameSpan() throws InterruptedException {
        logger.info("Same Span");
        sleuthService.doSomeWorkSameSpan();
        return "success";
    }

    @RequestMapping(value = "/available")
    public String available() {
        logger.info("Welcome to available");
        return "service 2";
    }
    @RequestMapping(value = "/checked-out")
    public String checkedOut() throws InterruptedException {
        Thread.sleep( 2000);
        logger.info("Welcome to sleuth");
        return "check in service 2";
    }




}
