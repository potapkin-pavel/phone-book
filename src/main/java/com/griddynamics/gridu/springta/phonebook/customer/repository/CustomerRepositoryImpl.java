package com.griddynamics.gridu.springta.phonebook.customer.repository;

import com.griddynamics.gridu.springta.phonebook.customer.domain.Customer;
import com.griddynamics.gridu.springta.phonebook.customer.exception.CustomerExistException;
import com.griddynamics.gridu.springta.phonebook.customer.exception.CustomerNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {

    private List<Customer> data;

    public CustomerRepositoryImpl(List<Customer> data) {
        this.data = data;
    }

    @Override
    public List<Customer> findAll() {
        return data;
    }

    @Override
    public Customer findByName(String name) throws CustomerNotFoundException {
        for (Customer customer: data) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        throw new CustomerNotFoundException("Customer is not found");
    }

    @Override
    public Customer add(Customer customer) throws CustomerExistException {
        if (!data.contains(customer)) {
            data.add(customer);
            return customer;
        } else {
            throw new CustomerExistException("Customer already exist");
        }
    }

    @Override
    public Customer update(String name, Customer customer) throws CustomerNotFoundException {
        int index = data.indexOf(findByName(name));
        data.set(index, customer);
        return customer;
    }

    @Override
    public void delete(String name) throws CustomerNotFoundException {
        data.remove(findByName(name));
    }

}
