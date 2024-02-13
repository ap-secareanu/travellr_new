package com.travellr.travellr.repository;

import com.travellr.travellr.model.Country;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CountriesRepo extends CrudRepository<Country, Integer> {
  @Query(value = "SELECT country_code FROM countries WHERE LOWER(country_name) LIKE '%' || :input || '%'", nativeQuery = true)
  List<String> findByInput(@Param("input") String input);

  @Query(value = "SELECT * from countries WHERE country_code=:code", nativeQuery = true)
  Country findByCountryCode(@Param("code") String code);
}
