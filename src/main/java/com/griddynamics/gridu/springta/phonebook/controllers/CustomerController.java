package com.griddynamics.gridu.springta.phonebook.controllers;

import com.griddynamics.gridu.springta.phonebook.domain.Customer;
import com.griddynamics.gridu.springta.phonebook.exceptions.CustomerExistException;
import com.griddynamics.gridu.springta.phonebook.exceptions.CustomerNotFoundException;
import com.griddynamics.gridu.springta.phonebook.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final String APPLICATION_JSON = "application/json";
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping(path = "/{name}")
    public Customer getCustomerByName(@PathVariable("name") String name) throws CustomerNotFoundException {
        return customerService.findByName(name);
    }

    @PostMapping(path = "/", consumes = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) throws CustomerExistException {
        return customerService.add(customer);
    }

    @PutMapping(path = "/{name}", consumes = APPLICATION_JSON)
    public Customer updateCustomerByName(@PathVariable("name") String name, @RequestBody Customer customer)
            throws CustomerNotFoundException {
        return customerService.update(name, customer);
    }

    @DeleteMapping(path = "/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerByName(@PathVariable("name") String name) throws CustomerNotFoundException {
        customerService.delete(name);
    }

}
