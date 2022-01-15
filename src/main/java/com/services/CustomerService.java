package com.services;

import com.dao.CustomerRepo;
import com.model.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerService {


    @Autowired
    private CustomerRepo customerRepo;

    public CustomerModel createCustomer(CustomerModel customerModel) {
        return customerRepo.save(customerModel);
    }

}
