package com.travellr.travellr.model;

import jakarta.persistence.*;

@Entity
@Table(name = "visited_countries")
public class VisitedCountry {
  
  @Id
  @GeneratedValue
  private Integer id;

  private String country_code;
  private String country_name;
  private String visited_by;

  private VisitedCountry() {};

  public VisitedCountry(String country_code, String visited_by, String country_name) {
    this.country_code = country_code;
    this.country_name = country_name;
    this.visited_by = visited_by;
  }

  public Integer getId() {
    return this.id;
  }

  public String getCountryCode() {
    return this.country_code;
  }

  public String getCountryName() {
    return this.country_name;
  }

  public String getVisitedBy() {
    return this.visited_by;
  }
}
