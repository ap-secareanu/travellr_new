package com.travellr.travellr.repository;

import com.travellr.travellr.model.VisitedCountry;
import org.springframework.data.repository.CrudRepository;

public interface VisitedCountriesRepo extends CrudRepository<VisitedCountry, Integer> {};
