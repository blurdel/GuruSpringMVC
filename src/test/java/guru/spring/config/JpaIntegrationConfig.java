package guru.spring.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;


@Configuration
@EnableAutoConfiguration
@ComponentScan("guru.spring")
public class JpaIntegrationConfig {
}
