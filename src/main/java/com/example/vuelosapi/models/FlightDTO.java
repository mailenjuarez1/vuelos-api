package com.example.vuelosapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlightDTO {
    private Long id;
    private String origin;
    private String destination;
    private String departureDateTime;
    private String arrivalDateTime;
    private double convertedPrice;
    private String frequency;
    private Company company;
}

