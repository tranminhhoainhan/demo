package com.cybermax.samples.spring_native_service.models;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Data
@Document(collection = "case_not_life_premium")
public class CaseNotLifePremium {

	@MongoId(FieldType.OBJECT_ID)
	private String id;
	
	private Integer activeStatus;
	
	@Field("branch")			
	private String branchName;

	@Field("branches_id")			
	@DocumentReference(lazy = true)
	private Branche branche;
	
	private String caseValidationStatus;
	private String caseVariant;
	private String category;
	
    @Field(name = "cedants_id",targetType = FieldType.OBJECT_ID)		 
	//@DocumentReference(lazy = true)
	//private Cedant cedant;
	private String cedantId;
	
	private Integer commissionCession;
	private Object commissionRefunded;
	
	@Field("date_effective")	
	private Date dateEffective;
	
	@Field("date_transaction")	
	private Date dateTransaction;
	
	private String deadline;
	private Double insuredCapital;
	private Object invoicedPremium;
	private String natureRisqueId;
	private Object netAmount;
	private Double paidCommission;
	private Double partCedantCoass;
	private String policyNumber;
	private Double premiumCeded;
	
	@Field("premium_ht")		
	private Double premiumHt;
	
	private Double primeNetCeded;
	
    @Field(name = "slipes_prime_id",targetType = FieldType.OBJECT_ID)		 
	@DocumentReference(lazy = false)
	private SlipPremium slipesPrime;
	//private String slipesPrimeId;
	
	@Field("sub_branches_id")				
	@DocumentReference(lazy = true)
	private Branche subBranche;
	
	@Field("updated_at")	
	private String updatedAt;	
	
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}