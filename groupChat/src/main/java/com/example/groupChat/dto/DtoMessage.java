package com.example.groupChat.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DtoMessage {

    private String text;
    private String datetime;
    private String username;
}
