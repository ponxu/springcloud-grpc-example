package com.ponxu.test.controller;

import com.ponxu.test.Greeting;
import org.springframework.stereotype.Component;

/**
 * @author ponxu
 * @date 2018-08-01
 */
@Component
public class GreetingServiceRemoteHystric implements GreetingServiceRemote {
    @Override
    public Greeting hello(String name) {
        return new Greeting(0, "hystric," + name);
    }
}
