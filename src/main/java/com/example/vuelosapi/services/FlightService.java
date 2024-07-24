package com.example.vuelosapi.services;

import com.example.vuelosapi.configuration.FlightConfiguration;
import com.example.vuelosapi.models.Dolar;
import com.example.vuelosapi.models.Flight;
import com.example.vuelosapi.models.FlightDTO;
import com.example.vuelosapi.repositorys.FlightRepository;
import com.example.vuelosapi.utils.FlightUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private FlightUtils flightUtils;
    @Autowired
    private FlightConfiguration flightConfiguration;


    //lista de todos los vuelos con mapper
    public List<FlightDTO> getAllFlights(){
        double getDollarPrice = getDollarPrice();
        List<Flight> flights = flightRepository.findAll();
        return flightUtils.flightListMapper(flights, getDollarPrice);
    }

    /*public List<FlightDTO> getAllFlights(){
        List<Flight> flightList = flightRepository.findAll();//vuelos de la BD
        return flightList.stream()
                .map(flight -> flightUtils.flightMapper(flight, getDollarPrice()))
                .collect(Collectors.toList());
        //lista de vuelosDTO
        //lo transformo en listaDTO
    }*/

    public void createFlight(Flight flight){
        flightRepository.save(flight);
    }

    public Optional<Flight> findFlightById(Long id) {
       return flightRepository.findById(id);
    }

    public Optional<Flight> updateFlight(Flight flight) {
        flightRepository.save(flight);
        return flightRepository.findById(flight.getId());
    }

    public void deleteFlightById(Long id) {
        flightRepository.deleteById(id);
    }

    public List<Flight> getByOrigin(String origin){
        return flightRepository.findByOrigin(origin);
    }

    public List<Flight> getByOriginAndDestination(String origin, String destination){
        return flightRepository.findByOriginAndDestination(origin, destination);
    }

    /*
    OBTENER OFERTAS PROG. DECLARATIVA
    public List<Flight> getOffer(Integer offerPrice) {
        List<Flight> flights = flightRepository.findAll();
        List<Flight> offerFlights = new ArrayList<>();
        for (Flight flight: flights) {
            if (flight.getPrice() < offerPrice){
                    offerFlights.add(flight);
            }
        }
        return offerFlights;
    }*/

    /*
    OBTENER OFERTAS PROG. FUNCIONAL
    public List<Flight> getOffer(Integer offerPrice) {
        List<Flight> flights = flightRepository.findAll();
        List<Flight> offerFlights = flights.stream()
                .filter(flight -> flight.getPrice() < offerPrice)
                .collect(Collectors.toList());
        return offerFlights;
    }*/

    public List<Flight> getOffer(Integer offerPrice) {
        List<Flight> flights = flightRepository.findAll();
        return flightUtils.detectOffer(flights, offerPrice);
    }

    private double getDollarPrice() {
        return flightUtils.fetchDolar().getAverage();
    }

    public List<Dolar> getAllDollars() {
        return List.of(flightConfiguration.fetchAllDollars());
    }
}


