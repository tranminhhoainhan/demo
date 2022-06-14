package com.cybermax.samples.spring_native_service.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Data
@Document(collection = "countries")
public class Country {
	@MongoId(FieldType.OBJECT_ID)
	private String id;
	
	private String code;
	private String name;
	
	@Field("regions_id")
	@DocumentReference	
	private Region region;
	
	@Field("updated_at")		
	private Date updatedAt;
	
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}