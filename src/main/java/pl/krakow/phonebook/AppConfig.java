package pl.krakow.phonebook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pl.krakow.phonebook.customer.domain.Customer;

import java.util.ArrayList;
import java.util.List;

@EnableWebMvc
@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public List<Customer> createData() {
        List<Customer> data = new ArrayList<>();
        data.add(new Customer("Alex", "+15417543010"));
        data.add(new Customer("Smith", "+15316785690"));
        return data;
    }

}
