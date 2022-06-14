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
@Document(collection = "cedants")
public class Cedant {
	@MongoId(FieldType.OBJECT_ID)
	private String id;
	
	private Integer benefitPercentage;
	private String code;
	private String color1;
	private String color2;
	private String contact;
	
	//@Field("countries_id")	
	//@DocumentReference
    //private Country country;
	 
    @Field(name = "countries_id",targetType = FieldType.OBJECT_ID)	
    private String countryId;

	
	@Field("created_at")		
	private Date createdAt;
	
	private String currenciesId;
	private String email;
	private String estimationType;
	private String groupsCedantsId;
	private String logo;
	private String name;

	//@Field("region_id")	
	//@DocumentReference	
	//private Region region;
    @Field(name = "region_id",targetType = FieldType.OBJECT_ID)	
    private String regionId;	
	
	private String reinsurancesId;
	private String typesCedantsId;
	
	@Field("updated_at")	
	private String updatedAt;

	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}