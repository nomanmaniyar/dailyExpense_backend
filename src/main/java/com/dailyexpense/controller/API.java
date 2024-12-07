package com.dailyexpense.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class API {

    @GetMapping
    public String testApi() {
        return "......EXPENSE API......";
    }
}
