package com.imdach.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By Arthur Zhang at 2022/3/15
 */
@RestController
@RequestMapping("/test")
public class MyController {
    @Autowired
    MyService myService;

    @RequestMapping("/groovy")
    @ResponseBody
    public String hello() {
        myService.insert();
        return "hello";
    }

    @RequestMapping("/gc")
    @ResponseBody
    public String gc() {
        System.gc();
        return "gc done";
    }
}
