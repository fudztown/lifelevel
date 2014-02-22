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
package com.lifeleveler.service;

import com.lifeleveler.model.Users;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class UserRegistration {

    @Inject
    private EntityManager em;
    
    public void register(Users users) throws Exception {
        em.persist(users);
    }
    
    public void delete(Users users) throws Exception {
    	Object managed = em.merge(users);
    	em.remove(managed);
    }
    
    public void exists(Users users) throws Exception {
 
    }
}