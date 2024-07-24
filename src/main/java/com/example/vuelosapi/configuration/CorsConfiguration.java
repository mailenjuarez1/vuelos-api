package com.example.vuelosapi.configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfiguration implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")                        //direcciones que permito
                .allowedOrigins("/*")                               //a quienes permito acceder
                .allowedMethods("GET", "POST", "PUT", "DELETE")     //que metodos puede ejecutar
                .allowedHeaders("*");                               //seguridad y transpaso de info http
    }
}
