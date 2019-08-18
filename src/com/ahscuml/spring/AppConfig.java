package com.ahscuml.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ahscuml
 * @date 2019/5/11
 * @time 2:37
 */
@Configuration
public class AppConfig {
    @Bean(name = "baicai")
    public Food food(){
        return new Food("baicai");
    }

    @Bean(name = "ming")
    public Student student(){
        return new Student("ming");
    }
}
