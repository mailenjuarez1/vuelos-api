package com.example.vuelosapi.repositorys;

import com.example.vuelosapi.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//ESTE ES NUESTRO DAO
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByOrigin(String origin);
    List<Flight> findByOriginAndDestination(String origin, String destination);
}
