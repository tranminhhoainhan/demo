package com.cybermax.samples.spring_native_service.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.cybermax.samples.spring_native_service.api.RecRiskApi;
import com.cybermax.samples.spring_native_service.api.model.RecRiskListInner;
import com.cybermax.samples.spring_native_service.services.RECRiskService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RECRiskController implements RecRiskApi {
	
	@Autowired
    @Qualifier("RECRiskService")
	private RECRiskService recRiskService;

	@Override
	public ResponseEntity<List<RecRiskListInner>> apiV1RecRiskGet(String zone, String country, String group,
			String companyType, String cedant, String validationStatus, String confirmationStatus, Date publishedDate,
			Date editedPeriod, String mainBranch, Date dateCutoff, String method) {

		List<RecRiskListInner> data = recRiskService.getRECRiskList(zone,
						                      country,
						                      group,
			                                  companyType,
			                                  cedant,
			                                  validationStatus,
			                                  confirmationStatus,
			                                  publishedDate,
				                              editedPeriod,
				                              mainBranch,
				                              dateCutoff,
				                              method);
		ResponseEntity<List<RecRiskListInner>> ret = new ResponseEntity(data,HttpStatus.OK);
		return ret;
	}
}
