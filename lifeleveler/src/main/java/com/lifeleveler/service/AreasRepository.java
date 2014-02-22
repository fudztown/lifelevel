package com.lifeleveler.service;

import com.lifeleveler.model.Areas;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class AreasRepository {

    @Inject
    private EntityManager em;
    
    public void register(Areas areas) throws Exception {
        em.persist(areas);
    }
    
    public void delete(Areas areas) throws Exception {
    	Object managed = em.merge(areas);
    	em.remove(managed);
    }
    
    public void exists(Areas areas) throws Exception {
 
    }
}
