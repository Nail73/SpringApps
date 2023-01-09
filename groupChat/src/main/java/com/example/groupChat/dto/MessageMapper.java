package com.example.groupChat.dto;

import com.example.groupChat.models.Message;
import lombok.SneakyThrows;

import java.time.format.DateTimeFormatter;

public class MessageMapper {

    @SneakyThrows
    public static DtoMessage map(Message message) {

        DtoMessage dtoMessage = new DtoMessage();
        dtoMessage.setDatetime(message.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        dtoMessage.setUsername(message.getUser().getName());
        dtoMessage.setText(message.getMessage());
        return dtoMessage;
    }
}
