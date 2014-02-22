package com.lifeleveler.test;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.lifeleveler.model.Areas;
import com.lifeleveler.model.Categories;
import com.lifeleveler.service.AreasRepository;
import com.lifeleveler.service.CategoriesRepository;
import com.lifeleveler.util.Resources;

@RunWith(Arquillian.class)
public class CreateCategoriesTest {

	@Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(Areas.class, Categories.class, CategoriesRepository.class,  AreasRepository.class, Resources.class)
        		.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
        		.addAsResource("META-INF/persistence.xml");
    }

	@Inject
    CategoriesRepository categoriesRepository;

    @Test
	public void testUserInsert() throws Exception {
		Categories cat = new Categories();
		cat.setName("Personal Health");
		cat.setDescription("This section is dedicated to your health");
		cat.setPositionId(1);
		
		Areas area = new Areas();
		Areas area2 = new Areas();
		
		area.setName("Weight Lifting");
		area.setDescription("Picking stuff up");
		
		area2.setName("Running");
		area2.setDescription("Moving your legs quickly");
		
		cat.getAreas().add(area);
		cat.getAreas().add(area2);
		
		categoriesRepository.create(cat);
		
		assertTrue(cat.getAreas().contains(area));
		assertTrue(cat.getAreas().contains(area2));
		assertNotNull(cat.getCategoryId());
		
	}

}
