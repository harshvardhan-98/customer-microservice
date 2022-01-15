package com.controller;
import com.customerException.customerNotFoundException;
import com.dao.CustomerRepo;
import com.model.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    /**
     * Get all product
     * @return the product
     */
    @GetMapping(value = "/All")
    public List<CustomerModel> getProduct(){
        return customerRepo.findAll();
    }

    /**
     * To Create the customer
     * @param customerModel
     * @return list of customer
     */
    @PostMapping(value="/create")
    public CustomerModel createCustomer(@RequestBody CustomerModel customerModel){
        return customerRepo.save(customerModel);
    }

    /**
     * Search the customer by its ID
     * @param id
     * @return customer
     */
    @GetMapping("/{id}")
    public CustomerModel viewCustomers(@PathVariable Long id){
        CustomerModel customerModel=customerRepo.findById(id).orElseThrow(() -> new customerNotFoundException("ID Not Found" + " " + id));
        return customerModel;
    }

    /**
     * delete a specific customer by it's ID
     * @param id
     * @return confimation message
     */
    @DeleteMapping("/delete/{id}")
    String deleteProduct(@PathVariable Long id){
        try{
            customerRepo.deleteById(id);
        } catch (Exception e){
            throw new customerNotFoundException("ID Not Found" + " " + id);
        }
        return "ID Successfully Deleted";
    }

}
