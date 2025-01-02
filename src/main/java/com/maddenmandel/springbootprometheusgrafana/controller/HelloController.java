package com.maddenmandel.springbootprometheusgrafana.controller;

import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {
    @GetMapping("/hello")
    @Timed(value = "hello_controller_say_hello_duration_seconds", description = "Time taken to return hello")
    public String sayHello() {
        log.info("Saying hello");
        return "hello";
    }
}