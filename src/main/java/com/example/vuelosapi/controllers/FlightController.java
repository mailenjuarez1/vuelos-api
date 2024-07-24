package com.example.vuelosapi.controllers;


import com.example.vuelosapi.models.Dolar;
import com.example.vuelosapi.models.Flight;
import com.example.vuelosapi.models.FlightDTO;
import com.example.vuelosapi.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;



    //TRAIGO TODOS LOS VUELOS
    @GetMapping("/allflights")
    public List<FlightDTO> getAllFlights(){
        return flightService.getAllFlights();
    }

    //CREAR VUELO
    @PostMapping("/create")
    public void createFlight(@RequestBody Flight flight){
        flightService.createFlight(flight);
    }

    //BUSCAR POR ID
    @GetMapping("/{id}")
    public Optional<Flight> findFlightById(@PathVariable Long id){
        return flightService.findFlightById(id);
    }

    //ACTUALIZAR VUELO
    @PutMapping("/update")
    public Optional<Flight> updateFlight(@RequestBody Flight flight){
        return flightService.updateFlight(flight);
    }

    //BORRAR VUELO
    @DeleteMapping("/delete/{id}")
    public void deleteFlight(@PathVariable Long id){
        flightService.deleteFlightById(id);
    }

    //obtener ofertas
    @GetMapping("/offer")
    public List<Flight> getOffer(){
        Integer offerPrice = 150;
        return flightService.getOffer(offerPrice);
    }

    //obtener por origen por RequestParam
    @GetMapping("/origin")
    public List<Flight> getByOrigin(@RequestParam String origin){
        return flightService.getByOrigin(origin);
    }

    //obtener por origen y destino
    @GetMapping("/locations")
    public List<Flight> getByLocations(@RequestParam String origin, @RequestParam String destination){
        return flightService.getByOriginAndDestination(origin, destination);
    }

    /*@GetMapping("/dollarprice")
    public double getDollar(){
        return flightService.getDollarPrice();
    }*/

    @GetMapping("/alldollars")
    public List<Dolar> getAllDollars(){
        return flightService.getAllDollars();
    }


}
