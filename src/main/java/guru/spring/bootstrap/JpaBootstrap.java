package guru.spring.bootstrap;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.spring.domain.Customer;
import guru.spring.domain.Product;
import guru.spring.services.CustomerService;
import guru.spring.services.ProductService;


@Component
public class JpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private ProductService productService;
	private CustomerService customerService;
	
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		loadProducts();
		loadCustomers();
	}

	private void loadProducts() {
		
		Product product1 = new Product();
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImageUrl("http://www.example.com/product1.jpg");
        productService.saveOrUpdate(product1);

        Product product2 = new Product();
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("24.99"));
        product2.setImageUrl("http://www.example.com/product2.jpg");
        productService.saveOrUpdate(product2);

        Product product3 = new Product();
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal("34.99"));
        product3.setImageUrl("http://www.example.com/product3.jpg");
        productService.saveOrUpdate(product3);

        Product product4 = new Product();
        product4.setDescription("Product 4");
        product4.setPrice(new BigDecimal("44.99"));
        product4.setImageUrl("http://www.example.com/product4.jpg");
        productService.saveOrUpdate(product4);

        Product product5 = new Product();
        product5.setDescription("Product 5");
        product5.setPrice(new BigDecimal("59.99"));
        product5.setImageUrl("http://www.example.com/product5.jpg");
        productService.saveOrUpdate(product5);
	}

	private void loadCustomers() {
		
		Customer customer1 = new Customer();
        customer1.setFirstName("Zoey");
        customer1.setLastName("B");
        customer1.setAddressLine1("4TH ST N");
        customer1.setCity("Arlington");
        customer1.setState("VA");
        customer1.setZipCode("22204");
        customer1.setEmail("zoey@gmail.com");
        customer1.setPhoneNumber("305.333.0101");
        customerService.saveOrUpdate(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("Tana");
        customer2.setLastName("T");
        customer2.setAddressLine1("28 ST S");
        customer2.setCity("Arlington");
        customer2.setState("VA");
        customer2.setZipCode("22206");
        customer2.setEmail("tana@gmail.com");
        customer2.setPhoneNumber("305.323.0233");
        customerService.saveOrUpdate(customer2);

        Customer customer3 = new Customer();
        customer3.setFirstName("Sam");
        customer3.setLastName("Axe");
        customer3.setAddressLine1("Little Cuba Road");
        customer3.setCity("Miami");
        customer3.setState("Florida");
        customer3.setZipCode("33101");
        customer3.setEmail("sam@burnnotice.com");
        customer3.setPhoneNumber("305.426.9832");
        customerService.saveOrUpdate(customer3);
	}
	
}
