package com.lifeleveler.service;

import com.lifeleveler.model.Categories;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class CategoriesRepository {

    @Inject
    private EntityManager em;
    
    public void create(Categories categories) throws Exception {
        em.persist(categories);
    }
    
    public void delete(Categories categories) throws Exception {
    	Object managed = em.merge(categories);
    	em.remove(managed);
    }
    
    public void exists(Categories categories) throws Exception {
 
    }
}
