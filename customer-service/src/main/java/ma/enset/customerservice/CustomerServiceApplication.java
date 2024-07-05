package ma.enset.customerservice;

import ma.enset.customerservice.entities.Customer;
import ma.enset.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository ){
		return args -> {
			customerRepository.save(Customer.builder()
					.name("Sara")
					.email("sara@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("Zahra")
					.email("zahra@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("Anass")
					.email("anass@gmail.com")
					.build());
		};
	}
}
