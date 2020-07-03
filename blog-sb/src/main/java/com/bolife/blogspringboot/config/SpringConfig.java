package com.bolife.blogspringboot.config;

import com.bolife.blogspringboot.interceptor.HomeInterceptor;
import com.bolife.blogspringboot.util.FinalDefine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 14:15
 * @Description:
 */
@Configuration
public class SpringConfig implements WebMvcConfigurer{

    @Bean
    public HomeInterceptor getInterceptor(){
        return new HomeInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getInterceptor()).addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**").addResourceLocations("file:"+ FinalDefine.FILELOCATIONS);
    }
}
