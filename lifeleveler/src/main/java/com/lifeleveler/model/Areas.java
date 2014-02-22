/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the 
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lifeleveler.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@Entity
@XmlRootElement
@Table(name = "AREAS")
public class Areas implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="AREA_ID")
    private Integer areaId;
    
    @NotNull
    @Column(name="CATEGORY_ID")
    private Integer categoryId;
    
    @ManyToOne
    @JoinColumn(name="CATEGORY_ID")
    private Categories categories;
    

    @NotNull
    @Size(min = 1, max = 45)
    @Pattern(regexp = "[A-Za-z]*", message = "must contain only letters")
    @Column(name="NAME")
    private String name;
    
    @NotNull
    @Size(min = 1, max = 45)
    @Pattern(regexp = "[A-Za-z]*", message = "must contain only letters")
    @Column(name="DESCRIPTION")
    private String description;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", 
            updatable = false,
            columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dateCreated;
     

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIED_DATE", 
            updatable = false,
            columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date modifiedDate;


	public Integer getAreaId() {
		return areaId;
	}


	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}


	public Integer getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}


	public Categories getCategories() {
		return categories;
	}


	public void setCategories(Categories categories) {
		this.categories = categories;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}


	public Date getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	
	
	/*
    @OneToMany(mappedBy="users", cascade=CascadeType.ALL)
    private List<UserCategories> userCategories = new ArrayList<UserCategories>();
	*/
	
    
}
