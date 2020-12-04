package pl.krakow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.krakow.domain.Customer;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PhoneBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhoneBookApplication.class, args);
	}

	@Bean
	public List<Customer> createData() {
		List<Customer> data = new ArrayList<>();
		data.add(new Customer("Alex", "+15417543010"));
		data.add(new Customer("Smith", "+15316785690"));
		return data;
	}

}
