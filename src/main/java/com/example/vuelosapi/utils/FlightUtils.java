package com.example.vuelosapi.utils;

import com.example.vuelosapi.models.Dolar;
import com.example.vuelosapi.models.Flight;
import com.example.vuelosapi.models.FlightDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightUtils {


    private RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public Dolar fetchDolar(){
        RestTemplate restTemplate = restTemplate();
        String apiUrl = "https://dolarapi.com/v1/dolares/tarjeta";
        return restTemplate.getForObject(apiUrl, Dolar.class);
    }


    public List<Flight> detectOffer(List<Flight> flights, double offerPrice){
        return flights.stream()
                .filter(flight -> flight.getPrice() < offerPrice)
                .collect(Collectors.toList());
    }

    public FlightDTO flightMapper(Flight flight, double price){
        return new FlightDTO(flight.getId(),flight.getOrigin(), flight.getDestination(),
                flight.getDepartureDateTime(), flight.getArrivalDateTime(),
                price*flight.getPrice(), flight.getFrequency(), flight.getCompany());
    }

    public List<FlightDTO> flightListMapper(List<Flight> flights, double price){

        List<FlightDTO> flightDtos = new ArrayList<>();
        for (Flight flight: flights) {
            flightDtos.add(new FlightDTO(flight.getId(),flight.getOrigin(), flight.getDestination(),
                    flight.getDepartureDateTime(), flight.getArrivalDateTime(),
                    price*flight.getPrice(), flight.getFrequency(), flight.getCompany()));
        }
        return flightDtos;
    }

}
