package com.example.vuelosapi.configuration;

import com.example.vuelosapi.models.Dolar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class FlightConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    public Dolar[] fetchAllDollars(){
        RestTemplate restTemplate = restTemplate();
        String apiUrl = "https://dolarapi.com/v1/dolares";
        return restTemplate.getForEntity(apiUrl, Dolar[].class).getBody();
    }

}
