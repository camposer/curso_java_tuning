package config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
	@Bean
	@Profile("prod")
	public EntityManagerFactory entityManagerFactory() {
		return Persistence
				.createEntityManagerFactory("ejercicio2");
	}

	@Bean(name = "entityManagerFactory")
	@Profile("test")
	public EntityManagerFactory entityManagerFactoryTest() {
		return Persistence
				.createEntityManagerFactory("ejercicio2-test");
	}

	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(
			EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
