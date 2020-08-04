package app.client;

import app.model.SendResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("senderservice")
public interface SendToBossClient {

    @RequestMapping(value = "send/message/{messageContent}",
            method = RequestMethod.GET,
            consumes = "application/json")
    SendResponseDto sendFilteredCustomersToBoss(@PathVariable("messageContent") String messageContent);
}
