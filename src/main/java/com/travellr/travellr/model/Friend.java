package com.travellr.travellr.model;

import jakarta.persistence.*;

@Entity
@Table(name = "friends")
public class Friend {

  @Id
  @GeneratedValue
  private Integer id;

  private String name;
  private String master_user;
  private String color;

  private Friend() {};

  public Friend(String name, String master_user, String color) {
    this.name = name;
    this.master_user = master_user;
    this.color = color;
  }

  public Integer getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getMasterUser() {
    return this.master_user;
  }

  public String getColor() {
    return this.color;
  }

}
