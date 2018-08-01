package com.ponxu.test.controller;

import com.ponxu.test.Greeting;
import com.ponxu.test.GreetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ponxu
 * @date 2018-08-01
 */
@RestController
public class ServiceController implements GreetingService {
    @Value("${server.port}")
    private int port;

    @RequestMapping("/hello")
    public Greeting hello(String name) {
        System.out.println(name);
        return new Greeting(port, "hello, " + name);
    }
}
