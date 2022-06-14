package com.cybermax.samples.spring_native_service.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cybermax.samples.spring_native_service.models.CaseNotLifePremium;


public interface CaseNotLifePremiumRepository extends MongoRepository<CaseNotLifePremium, String> {

	@Query("{'cedantId': ?0 'branchName' : ?1}")
	List<CaseNotLifePremium> findCaseNotLifePremium(String cedantId, String branchName);
}
