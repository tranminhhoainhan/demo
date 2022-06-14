package com.cybermax.samples.spring_native_service.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cybermax.samples.spring_native_service.models.Branche;

public interface BrancheRepository extends MongoRepository<Branche, String> {

  public Branche findByName(String name);
  public Branche findByCode(String code);

}