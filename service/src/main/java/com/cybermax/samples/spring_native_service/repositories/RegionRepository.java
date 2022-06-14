package com.cybermax.samples.spring_native_service.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cybermax.samples.spring_native_service.models.Country;
import com.cybermax.samples.spring_native_service.models.Region;

public interface RegionRepository extends MongoRepository<Region, String> {

  public Region findByName(String name);
  public Region findByCode(String code);

}