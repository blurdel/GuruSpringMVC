package guru.spring.services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import guru.spring.domain.Customer;
import guru.spring.domain.User;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@ActiveProfiles("jpadao")
public class CustomerServiceJpaDaoImplTest {

	private CustomerService service;

	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.service = customerService;
	}
	
	@Test
	public void testList() {
		List<Customer> list = (List<Customer>) service.listAll();
		
		System.out.println("list size: " + list.size());
		for (Customer c : list) {
			System.out.println(c.toString());
		}
		
		assert(list.size() == 3);
	}
	
	@Test
	public void testSaveUser() {
		
		Customer cust = new Customer();

		User user = new User();
		user.setUsername("Zoey");
		user.setPassword("secret");
		cust.setUser(user);
		
		Customer saved = service.saveOrUpdate(cust);
		
		assert saved.getUser().getId() != null;
	}
}
