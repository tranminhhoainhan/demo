package com.cybermax.samples.spring_native_service.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cybermax.samples.spring_native_service.models.SlipPremium;

public interface SlipPremiumRepository extends MongoRepository<SlipPremium, String>{
	
    @Query("{'cedantId' : ?0 , 'band' : ?1}")
	List<SlipPremium> findSlipPremium(String cedantId);    
}
