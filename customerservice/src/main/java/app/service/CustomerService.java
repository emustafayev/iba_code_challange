package app.service;


import app.model.Customer;
import app.repo.CustomerRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public List<Customer> getFilteredCustomers(Integer creditAmount, Integer amountOfTime) {
        return customerRepo
                .findAllByMonthlyPaymentCapacityGreaterThan(getRequiredMonthly_payment_capacity(creditAmount, amountOfTime))  // payment info
                .stream()
                .sorted(Comparator.comparingInt(this::getNumberOfLatePayments))
                .collect(Collectors.toList());
    }

    private int getNumberOfLatePayments(Customer customer) {
        return (int)customer
                .getCredits_payment()
                .stream()
                .filter(cusDet -> cusDet.getPayment_time().isBefore(cusDet.getPaid_time()))
                .count();
    }

    private Integer getRequiredMonthly_payment_capacity(Integer creditAmount,Integer amountOfTime){
        log.info("Get the Amount of required monthly money!");
        return creditAmount/amountOfTime;
    }



}
