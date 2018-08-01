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
    private GreetingServiceRemote greetingServiceRemote;

    @RequestMapping(value = "/hello")
    public Greeting hello(String name) {
        return greetingServiceRemote.hello(name);
    }
}

