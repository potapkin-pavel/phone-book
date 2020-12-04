package pl.krakow.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.krakow.domain.Customer;
import pl.krakow.exception.CustomerExistException;
import pl.krakow.exception.CustomerNotFoundException;
import pl.krakow.service.CustomerRepository;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(path = { "", "/" })
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping(path = "/{name}")
    public Customer getCustomerByName(@PathVariable("name") String name) {
        try {
            return customerRepository.findByName(name);
        }
        catch (CustomerNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = { "", "/" }, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) {
        try {
            return customerRepository.add(customer);
        }
        catch (CustomerExistException exception) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    @PutMapping(path = "/{name}", consumes = "application/json")
    public Customer getCustomerByName(@PathVariable("name") String name, @RequestBody Customer customer) {
        try {
            return customerRepository.update(name, customer);
        }
        catch (CustomerNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerByName(@PathVariable("name") String name) {
        try {
            customerRepository.delete(name);
        }
        catch (CustomerNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
