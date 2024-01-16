package com.travellr.travellr.model;

import jakarta.persistence.*;

@Entity
@Table(name = "countries")
public class Country {
  
  @Id
  @GeneratedValue
  private Integer id;

  private String country_code;
  private String country_name;

  private Country() {};
  
  public Country(String country_code, String country_name) {
    this.country_code = country_code;
    this.country_name = country_name;
  }

  public String getCountryCode() {
    return this.country_code;
  }

  public String getCountryName() {
    return this.country_name;
  }
  
}
