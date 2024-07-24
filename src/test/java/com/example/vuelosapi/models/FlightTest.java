package com.example.vuelosapi.models;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FlightTest {
    private static Flight flight;

    @BeforeAll
    public static void setUp(){
        System.out.println("Se crea un vuelo");
        flight = new Flight();
    }
    @Test
    public void setAndGetOriginTest(){
        String testedOrigin = "COR";
        flight.setOrigin(testedOrigin);
        System.out.println("Se asigna el origen " + testedOrigin);
        Assertions.assertEquals(flight.getOrigin(), testedOrigin);
        //Assertions.assertEquals(flight.getOrigin(), "MDQ");     TEST FAILED
    }

    @Test
    public void setAndGetDestinationTest(){
        String testedDestination = "USH";
        flight.setDestination(testedDestination);
        System.out.println("Se setea el destino " + testedDestination);
        Assertions.assertEquals(flight.getDestination(), testedDestination);
    }

    @Test
    public void setAndGetFrequency(){
        String testedFrequency = "Diaria";
        flight.setFrequency(testedFrequency);
        System.out.println("Se setea la frecuencia " + testedFrequency);
        Assertions.assertEquals(flight.getFrequency(), testedFrequency);
    }

}