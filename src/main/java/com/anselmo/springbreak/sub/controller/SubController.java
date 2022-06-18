package com.anselmo.springbreak.sub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sub")
public class SubController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
    public String subMain(){
        return "hello sub";
    }
}
