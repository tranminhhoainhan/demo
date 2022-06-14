package com.cybermax.samples.spring_native_service.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cybermax.samples.spring_native_service.models.Country;

public interface CountryRepository extends MongoRepository<Country, String> {

  public Country findByName(String name);
  public Country findByCode(String code);
  
}