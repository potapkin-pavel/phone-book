package com.griddynamics.gridu.springta.phonebook.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

    private String name;
    private String number;

    public Customer() {}

}
