package pl.krakow.phonebook.customer.repository;

import pl.krakow.phonebook.customer.domain.Customer;
import pl.krakow.phonebook.customer.exception.CustomerExistException;
import pl.krakow.phonebook.customer.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

    Customer findByName(String name) throws CustomerNotFoundException;

    Customer add(Customer customer) throws CustomerExistException;

    Customer update(String name, Customer customer) throws CustomerNotFoundException;

    void delete(String name) throws CustomerNotFoundException;

}