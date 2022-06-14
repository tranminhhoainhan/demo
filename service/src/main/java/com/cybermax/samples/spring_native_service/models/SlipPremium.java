package com.cybermax.samples.spring_native_service.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Data
@Document(collection = "slips_premium")
public class SlipPremium {
	@MongoId(FieldType.OBJECT_ID)
	private String id;
	
	private String approvalStatus;
	
	@Field("cedants_id")				
	@DocumentReference	
	private Cedant cedant;
	
		
    //@Field(name = "cedants_id",targetType = FieldType.OBJECT_ID)
	//private String cedantId;
	
	private String cedantsTypeId;
	private Object commissionRefundedTotal;
	
	@Field("confirmation_date")				
	private Date confirmationDate;
	
	@Field("confirmation_status")					
	private String confirmationStatus;
	
	@Field("created_at")			
	private String createdAt;
	
	@Field("edited_period")					
	private Date editedPeriod;
	
	private String fileUrl;
	private Object invoicePremiumTotal;
	private Integer isPaid;
	private Object netAmountTotal;
	
	@Field("published_date")			
	private Date publishedDate;
	
	private String reference;
	private String reinsurancesId;
	private String slipType;
	private Integer updateProgress;
	private Integer updateStatus;
	
	@Field("updated_at")			
	private Date updatedAt;
	
	private String userCedantId;
	
	@Field("validation_date")		
	private Date validationDate;
	
	@Field("validation_status")					
	private String validationStatus;
	
	private Integer warningsSaved;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}