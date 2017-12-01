package com.lw.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("zuul-gateway")
public interface HelloServiceFeign {

	@RequestMapping(value="/eureka-client/hi",method=RequestMethod.GET)
	String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
