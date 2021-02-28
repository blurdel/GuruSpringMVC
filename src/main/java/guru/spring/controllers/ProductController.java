package guru.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guru.spring.domain.Product;
import guru.spring.services.ProductService;


@Controller
public class ProductController {

	private ProductService productService;
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	
	@RequestMapping("/products")
	public String listProducts(Model model) {
		
		model.addAttribute("products", productService.listAll());
		return "products";
	}
	
	
	@RequestMapping("/product/{id}")
	public String getProduct(@PathVariable Integer id, Model model) {
		
		model.addAttribute("product", productService.getById(id));
		return "product";
	}
	
	@RequestMapping("/product/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("product", productService.getById(id));
		return "productform";
	}
	
	@RequestMapping("/product/new")
	public String newProduct(Model model) {
		
		model.addAttribute("product", new Product());
		return "productform";
	}
	
	
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String saveOrUpdate(Product product) {
		Product p = productService.saveOrUpdate(product);
		return "redirect:/product/" + p.getId();	
	}

	@RequestMapping("/product/delete/{id}")
	public String delete(@PathVariable Integer id) {
		productService.delete(id);
		return "redirect:/products";
	}
}