package com.cybermax.samples.spring_native_service.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import static org.springframework.data.domain.ExampleMatcher.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.*;
import org.springframework.stereotype.Service;

import com.cybermax.samples.spring_native_service.api.model.RecRiskData;
import com.cybermax.samples.spring_native_service.api.model.RecRiskListInner;
import com.cybermax.samples.spring_native_service.models.Branche;
import com.cybermax.samples.spring_native_service.models.CaseNotLifePremium;
import com.cybermax.samples.spring_native_service.models.Cedant;
import com.cybermax.samples.spring_native_service.models.Country;
import com.cybermax.samples.spring_native_service.models.SlipPremium;
import com.cybermax.samples.spring_native_service.repositories.BrancheRepository;
import com.cybermax.samples.spring_native_service.repositories.CaseNotLifePremiumRepository;
import com.cybermax.samples.spring_native_service.repositories.CedantRepository;
import com.cybermax.samples.spring_native_service.repositories.CountryRepository;
import com.cybermax.samples.spring_native_service.repositories.RegionRepository;
import com.cybermax.samples.spring_native_service.repositories.SlipPremiumRepository;
import com.cybermax.samples.spring_native_service.services.RECRiskService;

@Service("RECRiskService")
public class RECRiskServiceImpl implements RECRiskService {
	@Autowired
	BrancheRepository brancheRepo;

	@Autowired
	CaseNotLifePremiumRepository caseNotLifePremiumRepo;

	@Autowired
	CedantRepository cedantRepo;

	@Autowired
	CountryRepository countryRepo;

	@Autowired
	RegionRepository regionRepo;

	@Autowired
	SlipPremiumRepository slipPremiumRepo;

	public static double METHOD = 0.36;
	
	//Should use aggregator pipeline here
	//But have not enough time to do that
	//Filter in the memory for a quick solution
	public List<RecRiskListInner> getRECRiskList(String region, String country, String group,
			String companyType, String cedant, String validationStatus, String confirmationStatus, Date publishedDate,
			Date editedPeriod, String mainBranch, Date dateCutoff, String method){
		List<RecRiskListInner> ret = new ArrayList<>();
		
		//Just for assignment purpose with NOT LIFE company type test data
		if (companyType.compareToIgnoreCase("NOT LIFE") != 0) return ret;
		
		Country countryObj = countryRepo.findByName(country);
		if (countryObj == null) return ret;
		
		List<Cedant> cedantList = cedantRepo.findCedants(cedant, countryObj.getId(), countryObj.getRegion().getId());

		for (Cedant cedantItem : cedantList) {
			List<CaseNotLifePremium> caseNotLifePremiumList = caseNotLifePremiumRepo.findCaseNotLifePremium(cedantItem.getId(),mainBranch);
			for (CaseNotLifePremium caseNotLifePremiumItem : caseNotLifePremiumList) {
				
				//DateCutOff ???
				Date dateEffective = caseNotLifePremiumItem.getDateEffective();
				if (!DateUtils.isSameDay(dateEffective,dateCutoff)) continue;
				
					SlipPremium slipPremium = caseNotLifePremiumItem.getSlipesPrime();
				if ( DateUtils.isSameDay(slipPremium.getPublishedDate(),publishedDate)
						&&  samePeriod(slipPremium.getEditedPeriod(),editedPeriod)
						&& slipPremium.getValidationStatus().compareToIgnoreCase(validationStatus) == 0
						&& slipPremium.getConfirmationStatus().compareToIgnoreCase(confirmationStatus) == 0)		
				{
							RecRiskData data = new RecRiskData();
							data.reference(slipPremium.getReference());
							Country countryData = countryRepo.findByName(country);
							if (countryData != null )data.setCountry(countryData.getName());
							data.setCedant(slipPremium.getCedant().getName());
							data.setValidationStatus(slipPremium.getValidationStatus());
							data.setConfirmationStatus(slipPremium.getConfirmationStatus());
							data.setPublishedDate(slipPremium.getPublishedDate().toLocaleString());
							data.setBrache(caseNotLifePremiumItem.getBranchName());
							Double value = caseNotLifePremiumItem.getPremiumHt();
							data.setCalculatedRec((value !=null)? value*METHOD:0L);
							ret.add(data);
				}							
			}			
		} 
		
		return ret;
	}
	
	public boolean samePeriod(Date date1, Date date2) {
		if (date1.getYear() == date2.getYear() && date1.getMonth() == date2.getMonth()) return true;
		return false;
	}
}
