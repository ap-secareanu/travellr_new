package com.travellr.travellr.repository;
import com.travellr.travellr.model.Friend;
import org.springframework.data.repository.CrudRepository;

public interface FriendsRepo extends CrudRepository<Friend, Integer> {
  
}
