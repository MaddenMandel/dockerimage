package com.maddenmandel.springbootprometheusgrafana.controller;

import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    @Timed(value = "hello_controller_say_hello_duration_seconds", description = "Time taken to return hello")
    public String sayHello() {
        return "hello";
    }
}