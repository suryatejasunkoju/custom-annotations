package com.example.annotations.controller;

import com.example.annotations.custom.AllowByHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping
public class MyController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/protected1")
    @AllowByHeader(value = "fac")
    public String employee() {
        return "Hello, I am employee";
    }

    @GetMapping("/protected2")
    @AllowByHeader(value = "stu")
    public String get() {
        System.out.println("In get");
        return "Hello, I am student";
    }

//    @GetMapping("/protected3")
//    @AllowByHeader(value = "stu")
//    public String get2() {
//        //before coming control to this method, it is validating for header
//        System.out.println("In get2");
//        //this method calls get() which internally won't validate header
//        // because get() is executed as normal method but not as controller method.
////        return get();
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("employeetype", "");
//        String response = String.valueOf(restTemplate.getForEntity("http://localhost:8080/protected2", String.class));
//        System.out.println(response);
//        return response;
//    }
}

