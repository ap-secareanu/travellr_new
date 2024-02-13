package com.travellr.travellr.model;

import jakarta.persistence.*;

@Entity
@Table(name = "countries")
public class Country {
  
  @Id
  private Integer id;

  private String country_code;
  private String country_name;

  private Country() {};
  
  public Country(Integer id, String country_code, String country_name) {
    this.id = id;
    this.country_code = country_code;
    this.country_name = country_name;
  }

  public Integer getCountryId() {
    return this.id;
  }

  public String getCountryCode() {
    return this.country_code;
  }

  public String getCountryName() {
    return this.country_name;
  }
  
}
