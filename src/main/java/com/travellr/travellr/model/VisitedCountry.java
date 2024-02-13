package com.travellr.travellr.model;

import jakarta.persistence.*;

@Entity
@Table(name = "visited_countries")
public class VisitedCountry {
  
  @Id
  @GeneratedValue
  private Integer id;

  private String countryCode;
  private String countryName;
  private String visitedBy;

  private VisitedCountry() {};

  public VisitedCountry(String countryCode, String visitedBy, String countryName) {
    this.countryCode = countryCode;
    this.countryName = countryName;
    this.visitedBy = visitedBy;
  }

  public Integer getId() {
    return this.id;
  }

  public String getCountryCode() {
    return this.countryCode;
  }

  public String getCountryName() {
    return this.countryName;
  }

  public String getVisitedBy() {
    return this.visitedBy;
  }
}
