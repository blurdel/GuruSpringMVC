package guru.spring.config;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories("guru.spring.repositories")
public class CommonBeanConfig {

	@Bean
	public StrongPasswordEncryptor getEncryptor() {
		return new StrongPasswordEncryptor();
	}
	
}
