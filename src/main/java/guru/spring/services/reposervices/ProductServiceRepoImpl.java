package guru.spring.services.reposervices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.spring.domain.Product;
import guru.spring.repositories.ProductRepository;
import guru.spring.services.ProductService;


@Service
@Profile({"springdatajpa"})//, "jpadao"})
public class ProductServiceRepoImpl implements ProductService {

	private ProductRepository repo;
	
	
	@Autowired
	public void setRepo(ProductRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<?> listAll() {
		List<Product> list = new ArrayList<>();
		repo.findAll().forEach(list::add);
		return list;
	}

	@Override
	public Product getById(Integer id) {
		Optional<Product> p = repo.findById(id);
		return p.get();
	}

	@Override
	public Product saveOrUpdate(Product domainObj) {
		return repo.save(domainObj);
	}

	@Override
	public void delete(Integer id) {
		repo.delete(getById(id));
	}

}
