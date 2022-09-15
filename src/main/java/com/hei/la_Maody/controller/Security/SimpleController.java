package com.hei.la_Maody.controller.Security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @GetMapping("/test/roles/admin")
    public String testRoleAdmin(){
        return "Log as admin";
    }

    @GetMapping("/test/roles/user")
    public String testRoleUser(){
        return "Log as user";
    }
}
