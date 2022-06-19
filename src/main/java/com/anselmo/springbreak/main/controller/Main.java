package com.anselmo.springbreak.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class Main {
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String main(){
        return "This is Main Page";
    }
}
