package com.griddynamics.gridu.springta.phonebook.customer.repository;

import com.griddynamics.gridu.springta.phonebook.customer.domain.Customer;
import com.griddynamics.gridu.springta.phonebook.customer.exception.CustomerExistException;
import com.griddynamics.gridu.springta.phonebook.customer.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

    Customer findByName(String name) throws CustomerNotFoundException;

    Customer add(Customer customer) throws CustomerExistException;

    Customer update(String name, Customer customer) throws CustomerNotFoundException;

    void delete(String name) throws CustomerNotFoundException;

}
