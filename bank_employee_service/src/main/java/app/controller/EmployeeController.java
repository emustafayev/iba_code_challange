package app.controller;


import app.model.SendResponseDto;
import app.model.XCustomer;
import app.service.EmployeeService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "employee/")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //get all customers
    @RequestMapping(value="/",method = RequestMethod.GET)
    public List<XCustomer> getAllCustomers(){
        return employeeService.getAllCustomers();
    }



    //Get filtered customers
    @RequestMapping(value = "filterEmployee/creditAmount/{creditAmount}/amountOfTime/{amountOfTime}",method = RequestMethod.GET)
    public List<XCustomer> getFilteredCustomers(@PathVariable("creditAmount") Integer creditAmount,
                                                @PathVariable("amountOfTime") Integer amountOfTime){
        return employeeService
                .filterEmployees(creditAmount,amountOfTime);
    }


    //get filtered customers and send it to boss
    @RequestMapping(value = "filterEmployee/sendtoboss/creditAmount/{creditAmount}/amountOfTime/{amountOfTime}",method = RequestMethod.GET)
    public SendResponseDto getFilteredCustomersAndSendToBoss(@PathVariable("creditAmount") Integer creditAmount,
                                                             @PathVariable("amountOfTime") Integer amountOfTime){
        return employeeService
                .sendToBoss(creditAmount,amountOfTime);
    }




}
