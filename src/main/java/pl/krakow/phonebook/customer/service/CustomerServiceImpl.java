package pl.krakow.phonebook.customer.service;

import org.springframework.stereotype.Service;
import pl.krakow.phonebook.customer.domain.Customer;
import pl.krakow.phonebook.customer.exception.CustomerExistException;
import pl.krakow.phonebook.customer.exception.CustomerNotFoundException;
import pl.krakow.phonebook.customer.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findByName(String name) throws CustomerNotFoundException {
        return customerRepository.findByName(name);
    }

    public Customer add(Customer customer) throws CustomerExistException {
        return customerRepository.add(customer);
    }

    public Customer update(String name, Customer customer) throws CustomerNotFoundException {
        return customerRepository.update(name, customer);
    }

    public void delete(String name) throws CustomerNotFoundException {
        customerRepository.delete(name);
    }

}
