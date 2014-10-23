package za.co.demo.spring.boot.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import za.co.demo.spring.boot.Application;
import za.co.demo.spring.boot.resource.UserResource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UserTests {
	
	@Autowired
	private UserResource userResource;

	@Test
	public void testGetUser() {
		Long userId = 1L;
		User user = userResource.findOne(userId);
		assertNotNull(user);
		assertEquals("Naeem", user.getName());
	}

}
