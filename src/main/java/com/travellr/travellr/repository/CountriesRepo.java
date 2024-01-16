package com.travellr.travellr.repository;

import com.travellr.travellr.model.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountriesRepo extends CrudRepository<Country, Integer> {
  
}
