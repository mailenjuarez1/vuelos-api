package com.example.vuelosapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Flight {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String origin;
   private String destination;
   private String departureDateTime;
   private String arrivalDateTime;
   private double price;
   private String frequency;
   @ManyToOne
   @JoinColumn(name = "company_id")
   private Company company;

  public Flight(String origin, String destination, String departureDateTime, String arrivalDateTime, double price, String frequency) {
      this.origin = origin;
      this.destination = destination;
      this.departureDateTime = departureDateTime;
      this.arrivalDateTime = arrivalDateTime;
      this.price = price;
      this.frequency = frequency;
   }
}
