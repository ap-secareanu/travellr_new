package com.travellr.travellr.repository;

import org.springframework.data.repository.CrudRepository;
import com.travellr.travellr.model.User;
import java.util.Optional;

public interface UserRepo extends CrudRepository<User, Integer> {
  Optional<User> findByUsername(String username);
}