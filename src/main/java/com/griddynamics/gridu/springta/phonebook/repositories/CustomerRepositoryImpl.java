package com.griddynamics.gridu.springta.phonebook.repositories;

import com.griddynamics.gridu.springta.phonebook.domain.Customer;
import com.griddynamics.gridu.springta.phonebook.exceptions.CustomerExistException;
import com.griddynamics.gridu.springta.phonebook.exceptions.CustomerNotFoundException;
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
        return data.stream()
                .filter(customer -> name.equals(customer.getName()))
                .findAny().orElseThrow(() -> new CustomerNotFoundException(name));
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
