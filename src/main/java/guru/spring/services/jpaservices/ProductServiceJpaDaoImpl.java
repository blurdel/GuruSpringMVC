package guru.spring.services.jpaservices;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.spring.domain.Product;
import guru.spring.services.ProductService;


@Service
@Profile("jpadao")
public class ProductServiceJpaDaoImpl extends AbstractJpaDaoService implements ProductService {

	
	@Override
	public List<Product> listAll() {
		EntityManager em = emf.createEntityManager();
		
		return em.createQuery("from Product", Product.class).getResultList();
	}

	@Override
	public Product getById(Integer id) {
		EntityManager em = emf.createEntityManager();
		
		return em.find(Product.class, id);
	}

	@Override
	public Product saveOrUpdate(Product obj) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Product saved = em.merge(obj);
		em.getTransaction().commit();
		System.out.println("saved product id: " + saved.getId());
		return saved;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.remove(em.find(Product.class, id));
		em.getTransaction().commit();
	}

}
