package com.ponxu.test.controller;

import com.ponxu.test.Greeting;
import com.ponxu.test.GreetingService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xuwenzhao
 * @date 2018-08-01
 */
@FeignClient(value = "grpc-server")
public interface GreetingServiceRemote extends GreetingService {
    @RequestMapping(value = "/hello")
    Greeting hello(String name);
}
