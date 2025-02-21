package org.khalid.customerservice;

import org.khalid.customerservice.config.CustomerTestConfig;
import org.khalid.customerservice.config.GlobalConfig;
import org.khalid.customerservice.entities.Customer;
import org.khalid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({GlobalConfig.class, CustomerTestConfig.class})
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			List<Customer> customerList = List.of(
			Customer.builder()
					.firstName("Khalid")
					.lastName("Lid")
					.email("Lid@gmail.com")
					.build(),
			Customer.builder()
					.firstName("Ayoub")
					.lastName("ub")
					.email("ub@gmail.com")
					.build()
           );
			customerRepository.saveAll(customerList);
		};
	}
}
