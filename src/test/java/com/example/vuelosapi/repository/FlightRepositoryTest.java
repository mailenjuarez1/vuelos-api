package com.example.vuelosapi.repository;

import com.example.vuelosapi.models.Flight;
import com.example.vuelosapi.repositorys.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    private Flight flight;

    @BeforeEach
    void setup(){
        flight = new Flight("AEP","SAL","15-005-24","16-05-24",40000,"Semanal");
    }


    @Test
    void saveFlightTest(){
        //conf previa setUp
        Flight flightBD = flightRepository.save(flight); //Llamar a la funcionalidad testeamos el metodo save
        assertThat(flightBD).isNotNull(); //verifica comportamiento
        assertThat(flightBD.getId()).isGreaterThan(0);
    }


    @Test
    void findFlightByIdTest(){
        flightRepository.save(flight);  //traigo el vuelo creado en setup
        Flight flightBD =  flightRepository.findById(flight.getId()).get(); //funcionalidad
        assertThat(flightBD).isNotNull(); //verifica comportamiento
    }

   @Test
    void findAllFlightTest(){
       Flight flight1 = new Flight("BRA","ARG","15-005-24","16-05-24",40000,"Semanal");    //config previa
        flightRepository.save(flight);
        flightRepository.save(flight1);
        List<Flight> flightList = flightRepository.findAll();                              //funcionalidad
        assertThat(flightList).isNotNull();                                                //verifica comportamiento
        assertThat(flightList.size()).isEqualTo(2);
    }
}
