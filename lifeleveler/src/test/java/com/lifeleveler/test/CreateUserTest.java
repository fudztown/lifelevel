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

import com.lifeleveler.model.Users;
import com.lifeleveler.service.UserRegistration;
import com.lifeleveler.util.Resources;


@RunWith(Arquillian.class)
public class CreateUserTest {
	@Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(Users.class, UserRegistration.class, Resources.class)
        		.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
        		.addAsResource("META-INF/persistence.xml");
    }

	@Inject
    UserRegistration userRegistration;

    @Test
	public void testUserInsert() throws Exception {
		Users newUser = new Users();
		newUser.setFirst_name("Peter");
		newUser.setLast_name("Town");
		newUser.setEmail("peter.town@gmail.com");
		newUser.setPhoneNumber("01442259567");
		userRegistration.register(newUser);
		assertNotNull(newUser.getUser_id());
		//userRegistration.delete(newUser);
	}

}
