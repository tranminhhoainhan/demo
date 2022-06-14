package com.cybermax.samples.spring_native_service.services;

import java.util.Date;
import java.util.List;

import com.cybermax.samples.spring_native_service.api.model.RecRiskListInner;

public interface RECRiskService {
	public List<RecRiskListInner> getRECRiskList(String region, String country, String group,
			String companyType, String cedant, String validationStatus, String confirmationStatus, Date publishedDate,
			Date editedPeriod, String mainBranch, Date dateCutoff, String method);
}
