package pl.krakow.service;

import pl.krakow.domain.Customer;
import pl.krakow.exception.CustomerExistException;
import pl.krakow.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

    Customer findByName(String name) throws CustomerNotFoundException;

    Customer add(Customer customer) throws CustomerExistException;

    Customer update(String name, Customer customer) throws CustomerNotFoundException;

    void delete(String name) throws CustomerNotFoundException;

}
