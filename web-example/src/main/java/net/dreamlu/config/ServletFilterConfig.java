package net.dreamlu.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletFilterConfig {


	@Bean
	public FilterRegistrationBean kSecurityFilterRegister() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		//注入过滤器
		registration.setFilter(new net.dreamlu.common.filter.SimpleCORSFilter());
		//拦截规则
		registration.addUrlPatterns("/*");
		//过滤器名称
		registration.setName("simpleCORSFilter");
		//过滤器顺序
		registration.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE + 1);
		return registration;
	}


	@Bean
	public FilterRegistrationBean outLinkSecurityFilterRegister() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		//注入过滤器
		registration.setFilter(new com.kunlunsoft.rewriterequest.web.filter.RequestbodyFilter());
		//拦截规则
		registration.addUrlPatterns("/*");
		//过滤器名称
		registration.setName("requestbodyFilter");
		//过滤器顺序
		registration.setOrder(FilterRegistrationBean.HIGHEST_PRECEDENCE);
		return registration;
	}


}
