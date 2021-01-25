package com.griddynamics.gridu.springta.phonebook.repositories;

import com.griddynamics.gridu.springta.phonebook.domain.Customer;
import com.griddynamics.gridu.springta.phonebook.exceptions.CustomerExistException;
import com.griddynamics.gridu.springta.phonebook.exceptions.CustomerNotFoundException;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

    Customer findByName(String name) throws CustomerNotFoundException;

    Customer add(Customer customer) throws CustomerExistException;

    Customer update(String name, Customer customer) throws CustomerNotFoundException;

    void delete(String name) throws CustomerNotFoundException;

}
