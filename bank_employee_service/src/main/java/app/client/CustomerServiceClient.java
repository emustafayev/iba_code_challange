package app.client;


import app.model.XCustomer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("customerservice")
public interface CustomerServiceClient {

    @RequestMapping(value = "customers/{paymentAmount}/paymentTime/{amountOfTime}"
            ,method = RequestMethod.GET,
            consumes = "application/json")
    List<XCustomer> getFilteredCustomers(@PathVariable("paymentAmount") Integer creditAmount,
                                        @PathVariable("amountOfTime") Integer amountOfTime);



    @RequestMapping(value = "customers/",
            method = RequestMethod.GET,
            consumes = "application/json")
    List<XCustomer> getAllCustomers();
}
