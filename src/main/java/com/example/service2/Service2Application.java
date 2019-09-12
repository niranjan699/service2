package com.example.service2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Service2Application {

    public static void main ( String[] args ) {
        SpringApplication.run( Service2Application.class, args );
    }



    @RequestMapping(value = "/available")
    public String available() {
        return "service 2";
    }

    @RequestMapping(value = "/checked-out")
    public String checkedOut() throws InterruptedException {

        Thread.sleep( 2000);

        return "check in service 2";
    }

}
