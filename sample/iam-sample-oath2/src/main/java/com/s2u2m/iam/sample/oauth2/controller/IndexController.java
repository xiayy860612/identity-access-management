package com.s2u2m.iam.sample.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/pp/{ping}")
    public String pingPong(@PathVariable("ping") String ping) {
        return ping;
    }
}
