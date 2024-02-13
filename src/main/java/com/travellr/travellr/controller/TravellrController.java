package com.travellr.travellr.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.travellr.travellr.repository.FriendsRepo;
import com.travellr.travellr.repository.VisitedCountriesRepo;
import com.travellr.travellr.repository.CountriesRepo;
import com.travellr.travellr.repository.UserRepo;

import com.travellr.travellr.model.User;
import com.travellr.travellr.model.Friend;
import com.travellr.travellr.model.VisitedCountry;
import com.travellr.travellr.model.Country;

import java.util.Optional;
import java.util.List;

@RestController
@CrossOrigin
public class TravellrController {

  private final FriendsRepo friendsRepo;
  private final VisitedCountriesRepo visitedCountriesRepo;
  private final UserRepo userRepo;
  private final CountriesRepo countriesRepo;

  private TravellrController(FriendsRepo friendsRepo, CountriesRepo countriesRepo,
      VisitedCountriesRepo visitedCountriesRepo, UserRepo userRepo) {
    this.friendsRepo = friendsRepo;
    this.visitedCountriesRepo = visitedCountriesRepo;
    this.userRepo = userRepo;
    this.countriesRepo = countriesRepo;
  }

  @GetMapping("/friends")
  public Iterable<Friend> getAllFriends() {
    return this.friendsRepo.findAll();
  }

  @GetMapping("/country")
  public Country findCountry(@RequestParam("input") String input) {
    List<String> foundCode = this.countriesRepo.findByInput(input.toLowerCase());
    return this.countriesRepo.findByCountryCode(foundCode.get(0));
  }

  @PostMapping("/friends")
  public Friend addFriend(@ModelAttribute Friend friend) {
    return this.friendsRepo.save(friend);
  }

  @GetMapping("/visited")
  public Iterable<VisitedCountry> getAllCountries(@RequestParam("visitedBy") String visitedBy) {
    Iterable<VisitedCountry> foundCountries = this.visitedCountriesRepo.findAllByVisitedBy(visitedBy);
      return foundCountries;
  }

  @PostMapping("/visited")
  public VisitedCountry addVisitedCountry(@ModelAttribute VisitedCountry visitedCountry) {
    return this.visitedCountriesRepo.save(visitedCountry);
  }

  @PostMapping("/login")
  public String login(@ModelAttribute User user) {
    Optional<User> optionalUser = this.userRepo.findByUsername(user.getUsername());
    if (!optionalUser.isPresent()) {
      return null;
    }
    String hashedPw = optionalUser.get().getPassword();
    String paramPw = user.getPassword();
    if (BCrypt.checkpw(paramPw, hashedPw)) {
      return "Logged in!";
    } else {
      return "Wrong password or username.";
    }
  }

  @PostMapping("/register")
  public String register(@ModelAttribute User user) {
    Optional<User> optionalUser = this.userRepo.findByUsername(user.getUsername());
    if (!optionalUser.isPresent()) {
      user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
      this.userRepo.save(user);
      return "User registered succesfully!";
    } else {
      return "User already exists!";
    }
  }
}
