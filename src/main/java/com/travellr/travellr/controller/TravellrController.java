package com.travellr.travellr.controller;

import org.springframework.web.bind.annotation.*;
import com.travellr.travellr.repository.FriendsRepo;
import com.travellr.travellr.repository.VisitedCountriesRepo;
import com.travellr.travellr.repository.CountriesRepo;
import com.travellr.travellr.repository.UserRepo;
import com.travellr.travellr.model.User;
import com.travellr.travellr.model.Friend;
import com.travellr.travellr.model.VisitedCountry;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCrypt;

@RestController
public class TravellrController {

  private final FriendsRepo friendsRepo;
  private final VisitedCountriesRepo visitedCountriesRepo;
  private final UserRepo userRepo;

  private TravellrController(FriendsRepo friendsRepo, CountriesRepo countriesRepo, VisitedCountriesRepo visitedCountriesRepo, UserRepo userRepo) {
    this.friendsRepo = friendsRepo;
    this.visitedCountriesRepo = visitedCountriesRepo;
    this.userRepo = userRepo;
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

  @PostMapping("/login")
  public String login(@ModelAttribute User user) {
    Optional<User> optionalUser = this.userRepo.findByUsername(user.getUsername());
    if(!optionalUser.isPresent()) {
      return null;
    }
    String hashedPw = optionalUser.get().getPassword();
    String paramPw = user.getPassword();
    if(BCrypt.checkpw(paramPw, hashedPw)) {
      return "Logged in!";
    } else {
      return "Wrong password or username.";
    }
  }

  @PostMapping("/register")
  public String register(@ModelAttribute User user) {
    Optional<User> optionalUser = this.userRepo.findByUsername(user.getUsername());
    if(!optionalUser.isPresent()) {
      user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
      this.userRepo.save(user);
      return "User registered succesfully!";
    } else {
      return "User already exists!";
    }
  }
}
