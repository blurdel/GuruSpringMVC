package guru.spring.services.jpaservices;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.spring.domain.User;
import guru.spring.services.UserService;
import guru.spring.services.security.EncryptionService;


@Service
@Profile("jpadao")
public class UserServiceJpaDaoImpl extends AbstractJpaDaoService implements UserService {

	private EncryptionService encryptionService;
	
	@Autowired
	public void setEncryptionService(EncryptionService encryptionService) {
		this.encryptionService = encryptionService;
	}
	
	@Override
	public List<?> listAll() {
		EntityManager em = emf.createEntityManager();
		
		return em.createQuery("from User", User.class).getResultList();
	}

	@Override
	public User getById(Integer id) {
		EntityManager em = emf.createEntityManager();
		
		return em.find(User.class, id);
	}

	@Override
	public User saveOrUpdate(User obj) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		if (obj.getPassword() != null) {
			obj.setEncryptedPassword(encryptionService.encryptString(obj.getPassword()));
		}
		User saved = em.merge(obj);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.remove(em.find(User.class, id));
		em.getTransaction().commit();		
	}

}
