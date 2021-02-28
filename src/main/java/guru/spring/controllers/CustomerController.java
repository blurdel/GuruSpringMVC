package guru.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guru.spring.domain.Customer;
import guru.spring.services.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {

	private CustomerService service;
	
	
	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.service = customerService;
	}
	
	
	@RequestMapping({"/list", "/"})
	public String listAll(Model model) {
		model.addAttribute("customers", service.listAll());
		return "customer/list";
	}
	
	
	@RequestMapping("/show/{id}")
	public String getOne(@PathVariable Integer id, Model model) {
		model.addAttribute("customer", service.getById(id));
		return "customer/show";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("customer", service.getById(id));
		return "customer/customerform";
	}
	
	@RequestMapping("/new")
	public String newProduct(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer/customerform";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveOrUpdate(Customer customer) {
		Customer c = service.saveOrUpdate(customer);
		return "redirect:/customer/show/" + c.getId();	
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/customer/list";
	}
}
