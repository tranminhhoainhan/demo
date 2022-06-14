package com.cybermax.samples.spring_native_service.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cybermax.samples.spring_native_service.models.Cedant;
import com.cybermax.samples.spring_native_service.models.Country;

public interface CedantRepository extends MongoRepository<Cedant, String> {

  public Cedant findByName(String name);
  public Cedant findByCode(String code);
 
  @Query("{'name': ?0 'countryId' : ?1 , 'regionId' : ?2}")
  List<Cedant> findCedants(String name, String countryId,String regionId);    
}