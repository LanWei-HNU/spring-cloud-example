package com.lw.feign.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.commons.util.InetUtils;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class IpAddressThreadLocalInterceptor implements RequestInterceptor {
	
	private static final Logger log = LoggerFactory.getLogger(IpAddressThreadLocalInterceptor.class);

    private InetUtils inetUtils;
    
    public static final String IP_ADDRESS_LABEL = "x-ip-address";
    
    public IpAddressThreadLocalInterceptor(InetUtils inetUtils) {
        this.inetUtils = inetUtils;
    }

	@Override
	public void apply(RequestTemplate requestTemplate) {
		String ipAddress = inetUtils.findFirstNonLoopbackAddress().getHostAddress();
        requestTemplate.header(IP_ADDRESS_LABEL, ipAddress);

        log.info("ipAddress:{}", ipAddress);
    }

}
