package app.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SendResponseDto {
    String message;
    LocalDateTime messageTime;
}
