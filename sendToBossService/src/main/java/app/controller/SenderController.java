package app.controller;


import app.models.ResponseDto;
import app.service.MessageService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "send")
public class SenderController {

    private final MessageService messageService;

    public SenderController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(value = "/message/{messageContent}")
    public ResponseDto sendMessageToManager(@PathVariable("messageContent") String messageContent){
        return messageService.proceedMessage(messageContent);
    }

}
