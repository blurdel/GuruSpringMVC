package guru.spring.services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import guru.spring.domain.Product;


//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(JpaIntegrationConfig.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@ActiveProfiles("jpadao")
public class ProductServiceJpaDaoImplTest {

	private ProductService pService;

	
	@Autowired
	public void setpService(ProductService pService) {
		this.pService = pService;
	}
	
	@Test
	public void testListMethod() throws Exception {
		List<Product> pList = (List<Product>) pService.listAll();
		
		assert pList.size() == 5;
	}
}
