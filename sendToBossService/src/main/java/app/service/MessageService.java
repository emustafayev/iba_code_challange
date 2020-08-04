package app.service;


import app.models.ResponseDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class MessageService {
    public ResponseDto proceedMessage(String messageContent) {
        return (new Random().nextInt(4) != 1) ? new ResponseDto("Message confirmed successfully!", LocalDateTime.now()) :
                new ResponseDto("Message not confirmed!", LocalDateTime.now());
    }
}
