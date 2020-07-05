package com.bolife.blog.config;

import com.bolife.blog.intercepter.HomeResourceInterceptor;
import com.bolife.blog.intercepter.SecurityInterceptor;
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
    public HomeResourceInterceptor getInterceptor(){
        return new HomeResourceInterceptor();
    }
    @Bean
    public SecurityInterceptor getAdminInterceptor(){
        return new SecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(getAdminInterceptor()).addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/logout");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**").addResourceLocations("file:D:/226/git/gitreps/uploads/");
    }
}
