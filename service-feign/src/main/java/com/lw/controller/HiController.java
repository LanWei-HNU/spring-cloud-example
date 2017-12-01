package com.lw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lw.feign.HelloServiceFeign;

@RestController
public class HiController {

	@Autowired
	private HelloServiceFeign helloServiceFeign;
	
	@RequestMapping(value="/hi",method=RequestMethod.GET)
	public String sayHi(@RequestParam String name){
        return helloServiceFeign.sayHiFromClientOne(name);
    }
	
}
