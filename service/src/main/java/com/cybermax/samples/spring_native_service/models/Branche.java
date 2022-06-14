
package com.cybermax.samples.spring_native_service.models;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.FieldType;


@Data
@Document(collection = "branches")
public class Branche {
	@MongoId(FieldType.OBJECT_ID)
	private String id;

	private List<String> alias = null;
	private String code;
	
	@Field("created_at")	
	private Date createdAt;

	@Field("deleted_at")	
	private Date deletedAt;
	
	@Field("is_parent")		
	private Integer isParent;
	
	private String name;
	
	@Field("parent_branch_id")	
	@DocumentReference
	private Branche parentBranch;
	
	private Integer status;
	private String type;
	
	@Field("updated_at")	
	private Date updatedAt;	
}