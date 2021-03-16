package guru.spring.services.jpaservices;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.spring.domain.Customer;
import guru.spring.services.CustomerService;
import guru.spring.services.security.EncryptionService;


@Service
@Profile("jpadao")
public class CustomerServiceJpaDaoImpl extends AbstractJpaDaoService implements CustomerService {

	private EncryptionService encryptionService;
	
	@Autowired
	public void setEncryptionService(EncryptionService encryptionService) {
		this.encryptionService = encryptionService;
	}

	@Override
	public List<Customer> listAll() {
		EntityManager em = emf.createEntityManager();
		
		return em.createQuery("from Customer", Customer.class).getResultList();
	}

	@Override
	public Customer getById(Integer id) {
		EntityManager em = emf.createEntityManager();
		
		return em.find(Customer.class, id);
	}

	@Override
	public Customer saveOrUpdate(Customer obj) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		if (obj.getUser() != null && obj.getUser().getPassword() != null) {
			obj.getUser().setEncryptedPassword(
					encryptionService.encryptString(obj.getUser().getPassword()));
		}
		
		Customer saved = em.merge(obj); // Cascade will save Customer/USer
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.remove(em.find(Customer.class, id));
		em.getTransaction().commit();
	}

}
