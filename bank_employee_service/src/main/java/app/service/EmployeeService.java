package app.service;


import app.client.CustomerServiceClient;
import app.client.SendToBossClient;
import app.model.SendResponseDto;
import app.model.XCustomer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class EmployeeService {

    private final CustomerServiceClient customerServiceClient;
    private final SendToBossClient sendToBossClient;

    @Autowired
    public EmployeeService(CustomerServiceClient customerServiceClient, SendToBossClient sendToBossClient) {
        this.customerServiceClient = customerServiceClient;
        this.sendToBossClient = sendToBossClient;
    }

    public List<XCustomer> filterEmployees(Integer creditAmount, Integer amountOfTime) {
        return customerServiceClient.getFilteredCustomers(creditAmount, amountOfTime);
    }

    public List<XCustomer> getAllCustomers() {
        return customerServiceClient.getAllCustomers();
    }

    public SendResponseDto sendToBoss(Integer creditAmount, Integer amountOfTime) {
        String message = filterEmployees(creditAmount, amountOfTime).stream()
                .map(XCustomer::toString)
                .collect(Collectors.joining("\n"));
        String formattedMessage = formatMessage(message, creditAmount, amountOfTime);

        return sendToBossClient.sendFilteredCustomersToBoss(formattedMessage);
    }

    private String formatMessage(String message, Integer creditAmount, Integer amountOfTime) {
        return
                String.format("\n\t\t\t\t*****Customers with criteria: Credit amount: %d Amount Of Time %d ******\t\t\n\n\n%s\n",
                creditAmount,
                amountOfTime,
                message
        );
    }
}
