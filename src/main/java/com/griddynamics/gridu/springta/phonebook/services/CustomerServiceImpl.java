package com.griddynamics.gridu.springta.phonebook.services;

import com.griddynamics.gridu.springta.phonebook.domain.Customer;
import com.griddynamics.gridu.springta.phonebook.exceptions.CustomerExistException;
import com.griddynamics.gridu.springta.phonebook.exceptions.CustomerNotFoundException;
import com.griddynamics.gridu.springta.phonebook.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

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
