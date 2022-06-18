package com.anselmo.springbreak.helloworld.controller;

import com.anselmo.springbreak.helloworld.dto.HelloworldDTO;
import com.anselmo.springbreak.helloworld.dto.HelloworldDtoConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloworldController {
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getHello(){
        System.out.println("Hello");
        StringBuilder result = new StringBuilder();
        HelloworldDTO helloDto=new HelloworldDTO();
        helloDto.setHello("Get Mapping with Dto");

        HelloworldDtoConstructor helloDtoCon=new HelloworldDtoConstructor("생성자");
        result.append(helloDto.getHello());
        result.append(helloDtoCon.getFianlStr());
        return result.toString();
    }
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String getPost(){
        return "Post Mapping";
    }
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public String getPut(){
        return "Put Mapping";
    }
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public String getDelete(){
        return "Delete Mapping";
    }
}
