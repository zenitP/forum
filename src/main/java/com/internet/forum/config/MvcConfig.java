package com.internet.forum.config;

import com.internet.forum.domain.Topic;
import com.internet.forum.repos.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private TopicRepo topicRepo;

    public void addViewControllers(ViewControllerRegistry registry){

        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {



        registry.addResourceHandler("/images/**") // все запросы по этой маске будут перенаправляться по пути
                .addResourceLocations("file://"+uploadPath+"/");

        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/"); // при обращении при статик, ресурсы будут искаться в дереве проекта

    }
}
