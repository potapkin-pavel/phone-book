package com.griddynamics.gridu.springta.phonebook.customer.service;

import com.griddynamics.gridu.springta.phonebook.customer.domain.Customer;
import com.griddynamics.gridu.springta.phonebook.customer.exception.CustomerExistException;
import com.griddynamics.gridu.springta.phonebook.customer.exception.CustomerNotFoundException;
import com.griddynamics.gridu.springta.phonebook.customer.repository.CustomerRepository;
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
