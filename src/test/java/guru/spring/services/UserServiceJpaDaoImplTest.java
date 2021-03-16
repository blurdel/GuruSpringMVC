package guru.spring.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import guru.spring.domain.User;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@ActiveProfiles("jpadao")
public class UserServiceJpaDaoImplTest {

	private UserService service;

	@Autowired
	public void setUserService(UserService userService) {
		this.service = userService;
	}
	
	@Test
	public void testSaveUser() {
		
		User user = new User();
		user.setUsername("Zobert");
		user.setPassword("zoeybear");
		
		User saved =  service.saveOrUpdate(user);
		
		assert saved.getId() != null;
		assert saved.getEncryptedPassword() != null;
		
		System.out.println("Encrypted: " + saved.getEncryptedPassword());
	}
	
}
