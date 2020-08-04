package app.controller;


import app.model.Customer;
import app.service.CustomerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    // All customers
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }


    //Filtered customers, just go
    @RequestMapping(value = "/{paymentAmount}/paymentTime/{amountOfTime}")
    public List<Customer> filterFittingCustomers(@PathVariable("paymentAmount") Integer paymentAmount,
                                                 @PathVariable("amountOfTime") Integer amountOfTime){
        return customerService.getFilteredCustomers(paymentAmount,amountOfTime);
    }





}
