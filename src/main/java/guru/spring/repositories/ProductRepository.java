package guru.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.spring.domain.Product;


public interface ProductRepository extends CrudRepository <Product, Integer> {

}
