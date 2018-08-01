package com.ponxu.test.controller;

import com.ponxu.test.Greeting;
import com.ponxu.test.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ponxu
 * @date 2018-08-01
 */
@RestController
public class ServiceController implements GreetingService {
    @Autowired
    private GreetingServiceHttp greetingServiceHttp;
    @Autowired
    private GreetingServiceGRpc greetingServiceGRpc;

    @RequestMapping(value = "/hello")
    public Greeting hello(String name) {
        System.out.println(name);
        return greetingServiceHttp.hello(name);
    }

    @RequestMapping(value = "/hello2")
    public Greeting hello2(String name) {
        System.out.println(name);
        return greetingServiceGRpc.hello(name);
    }
}

