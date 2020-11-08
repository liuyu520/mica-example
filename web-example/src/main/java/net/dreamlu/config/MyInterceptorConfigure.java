package net.dreamlu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
public class MyInterceptorConfigure extends WebMvcConfigurerAdapter {
    @Autowired(required = false)
    private HandlerInterceptor handlerInterceptor;

    /**
     * {@inheritDoc}
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(handlerInterceptor /*new CacheSpringMvcHandle()*/);
        super.addInterceptors(registry);
    }
}
