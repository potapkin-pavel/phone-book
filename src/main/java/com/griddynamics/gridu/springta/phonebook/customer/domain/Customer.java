package com.griddynamics.gridu.springta.phonebook.customer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

    private String name;
    private String number;

    public Customer() {}

}
