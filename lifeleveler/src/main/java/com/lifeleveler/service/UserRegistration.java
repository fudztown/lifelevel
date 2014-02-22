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
