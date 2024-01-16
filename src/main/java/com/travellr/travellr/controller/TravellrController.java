package com.travellr.travellr.controller;

import org.springframework.web.bind.annotation.*;
import com.travellr.travellr.repository.FriendsRepo;
import com.travellr.travellr.repository.VisitedCountriesRepo;
import com.travellr.travellr.repository.CountriesRepo;
import com.travellr.travellr.model.Friend;
import com.travellr.travellr.model.Country;
import com.travellr.travellr.model.VisitedCountry;

@RestController
public class TravellrController {

  private final FriendsRepo friendsRepo;
  private final CountriesRepo countriesRepo;
  private final VisitedCountriesRepo visitedCountriesRepo;

  private TravellrController(FriendsRepo friendsRepo, CountriesRepo countriesRepo, VisitedCountriesRepo visitedCountriesRepo) {
    this.friendsRepo = friendsRepo;
    this.countriesRepo = countriesRepo;
    this.visitedCountriesRepo = visitedCountriesRepo;
  }
  
  @GetMapping("/friends")
  public Iterable<Friend> getAllFriends() {
    return this.friendsRepo.findAll();
  }

  @PostMapping("/friends")
  public Friend addFriend(@ModelAttribute Friend friend) {
    return this.friendsRepo.save(friend);
  }

  @GetMapping("/visited")
  public Iterable<VisitedCountry> getAllCountries() {
    return this.visitedCountriesRepo.findAll();
  }

  @PostMapping("/visited")
  public VisitedCountry addVisitedCountry(@ModelAttribute VisitedCountry visitedCountry) {
    return this.visitedCountriesRepo.save(visitedCountry);
  }
}
