package com.maddenmandel.springbootprometheusgrafana.controller;

import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);


    @GetMapping("/hello")
    @Timed(value = "hello_controller_say_hello_duration_seconds", description = "Time taken to return hello")
    public String sayHello() {
        logger.info("This is a test log message");
        log.info("Saying hello");
        return "hello";
    }
}
