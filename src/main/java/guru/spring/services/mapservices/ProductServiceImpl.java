package guru.spring.services.mapservices;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.spring.domain.DomainObject;
import guru.spring.domain.Product;
import guru.spring.services.ProductService;


@Service
@Profile("map")
public class ProductServiceImpl extends AbstractMapService implements ProductService {
	
	
	@Override
	public List<DomainObject> listAll() {
		return super.listAll();
	}

	@Override
	public Product getById(Integer id) {
		return (Product) super.getById(id);
	}


	@Override
	public Product saveOrUpdate(Product obj) {
		return (Product) super.saveOrUpdate(obj);
	}

	@Override
	public void delete(Integer id) {
		super.delete(id);
	}
	
/*	
	@Override
	protected void loadDomainObjects() {
		domainMap = new HashMap<>();
		
		Product product1 = new Product();
        product1.setId(1);
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("15.02"));
        product1.setImageUrl("http://www.example.com/product1.jpg");
        domainMap.put(1,product1);

        product1 = new Product();
        product1.setId(2);
        product1.setDescription("Product 2");
        product1.setPrice(new BigDecimal("5.28"));
        product1.setImageUrl("http://www.example.com/product2.jpg");
        domainMap.put(2,product1);

        product1 = new Product();
        product1.setId(3);
        product1.setDescription("Product 3");
        product1.setPrice(new BigDecimal("329.50"));
        product1.setImageUrl("http://www.example.com/product3.jpg");
        domainMap.put(3,product1);

        product1 = new Product();
        product1.setId(4);
        product1.setDescription("Product 4");
        product1.setPrice(new BigDecimal("78.99"));
        product1.setImageUrl("http://www.example.com/product4.jpg");
        domainMap.put(4,product1);

        product1 = new Product();
        product1.setId(5);
        product1.setDescription("Product 5");
        product1.setPrice(new BigDecimal("65.45"));
        product1.setImageUrl("http://www.example.com/product5.jpg");
        domainMap.put(5,product1);
	}
*/
}
