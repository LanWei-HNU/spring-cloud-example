package com.lw.eureka.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
@RefreshScope  
public class RestController {

	@Value("${server.port}")
	private String serverPort;
	
	@Value("${encryption.defaultEncryptKey}")
	private String desc;

	@RequestMapping("/hi")
	public String home(@RequestParam String name) {
		return "hi " + name + ",i am from port:" + serverPort+ ":  "+desc ;
	}
}
