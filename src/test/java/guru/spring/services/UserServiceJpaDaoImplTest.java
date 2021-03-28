package guru.spring.services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import guru.spring.domain.Cart;
import guru.spring.domain.CartDetail;
import guru.spring.domain.Customer;
import guru.spring.domain.Product;
import guru.spring.domain.User;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@ActiveProfiles("jpadao")
public class UserServiceJpaDaoImplTest {

	private UserService userService;
	private ProductService productService;
	

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	
//	@Test
//	public void testSaveUser() {
//		
//		User user = new User();
//		user.setUsername("Zobert");
//		user.setPassword("zoeybear");
//		
//		User saved =  userService.saveOrUpdate(user);
//		
//		assert saved.getId() != null;
//		assert saved.getEncryptedPassword() != null;
//		
//		System.out.println("Encrypted: " + saved.getEncryptedPassword());
//	}
	
//	@Test
//	public void testSaveUserWithCustomer() {
//		
//		User user = new User();
//		user.setUsername("MyUser");
//		user.setPassword("MyPassword");
//		
//		Customer cust = new Customer();
//		cust.setFirstName("Chevy");
//		cust.setLastName("Chase");
//		
//		user.setCustomer(cust);
//		
//		User saved =  userService.saveOrUpdate(user);
//		
//		assert saved.getId() != null;
//		assert saved.getVersion() != null;
//		assert saved.getCustomer() != null;
//		assert saved.getCustomer().getId() != null;
//	}
	
//	@Test
//    public void testAddCartToUser() throws Exception {
//        User user = new User();
//
//        user.setUsername("someusername");
//        user.setPassword("myPassword");
//
//        user.setCart(new Cart());
//
//        User savedUser = userService.saveOrUpdate(user);
//
//        assert savedUser.getId() != null;
//        assert savedUser.getVersion() != null;
//        assert savedUser.getCart() != null;
//        assert savedUser.getCart().getId() != null;
//    }
	
//	@Test
//    public void testAddCartToUserWithCartDetails() throws Exception {
//        User user = new User();
//
//        user.setUsername("someusername");
//        user.setPassword("myPassword");
//
//        user.setCart(new Cart());
//
//        List<Product> storedProducts = (List<Product>) productService.listAll();
//
//        CartDetail cartItemOne = new CartDetail();
//        cartItemOne.setProduct(storedProducts.get(0));
//        user.getCart().addCartDetail(cartItemOne);
//
//        CartDetail cartItemTwo = new CartDetail();
//        cartItemTwo.setProduct(storedProducts.get(1));
//        user.getCart().addCartDetail(cartItemTwo);
//
//        User savedUser = userService.saveOrUpdate(user);
//
//        assert savedUser.getId() != null;
//        assert savedUser.getVersion() != null;
//        assert savedUser.getCart() != null;
//        assert savedUser.getCart().getId() != null;
//        assert savedUser.getCart().getCartDetails().size() == 2;
//    }
//	
	@Test
    public void testAddAndRemoveCartToUserWithCartDetails() throws Exception {
        User user = new User();

        user.setUsername("someusername");
        user.setPassword("myPassword");

        user.setCart(new Cart());

        List<Product> storedProducts = (List<Product>) productService.listAll();

        CartDetail cartItemOne = new CartDetail();
        cartItemOne.setProduct(storedProducts.get(0));
        user.getCart().addCartDetail(cartItemOne);

        CartDetail cartItemTwo = new CartDetail();
        cartItemTwo.setProduct(storedProducts.get(1));
        user.getCart().addCartDetail(cartItemTwo);

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getCart().getCartDetails().size() == 2;

        savedUser.getCart().removeCartDetail(savedUser.getCart().getCartDetails().get(0));

        userService.saveOrUpdate(savedUser);

        assert savedUser.getCart().getCartDetails().size() == 1;
    }
	
	
}
