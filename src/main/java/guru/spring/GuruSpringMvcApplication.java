package guru.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


// To see what Spring is doing:
// --debug


@SpringBootApplication
public class GuruSpringMvcApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(GuruSpringMvcApplication.class, args);
		
		System.out.println("Beans *****");
		System.out.println("Beans: " + ctx.getBeanDefinitionCount());
		
//		for (String name : ctx.getBeanDefinitionNames()) {
//			System.out.println(name);
//		}
	}

}
