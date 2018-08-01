package com.ponxu.test.controller;

import com.ponxu.test.Greeting;
import com.ponxu.test.GreetingService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ponxu
 * @date 2018-08-01
 */
@FeignClient(value = "grpc-server", fallback = GreetingServiceHttpHystric.class)
public interface GreetingServiceHttp extends GreetingService {
    @RequestMapping(value = "/hello")
    Greeting hello(@RequestParam("name") String name);
}
