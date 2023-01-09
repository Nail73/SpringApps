package com.example.groupChat.controllers;

import com.example.groupChat.dto.DtoMessage;
import com.example.groupChat.dto.MessageMapper;
import com.example.groupChat.repository.MessageRepository;
import com.example.groupChat.repository.UserRepository;
import com.example.groupChat.services.MessageService;
import com.example.groupChat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ChatController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;

    private MessageMapper messageMapper;

    @GetMapping("/init")
    public HashMap<String, Boolean> init() {
        return userService.isAuth();
    }

    @PostMapping("/auth")
    public HashMap<String, Boolean> auth(@RequestParam String name) {
        return userService.auth(name);
    }

    @PostMapping("/message")
    public Map<String, Boolean> sendMessage(@RequestParam String message) {
        return messageService.sendMsg(message);
    }

    @GetMapping("/message")
    public List<DtoMessage> getMessagesList() {
        return messageRepository.findAll(Sort.by(Sort.Direction.ASC, "dateTime"))
                .stream()
                .map(MessageMapper::map)
                .collect(Collectors.toList());
    }

    @GetMapping("/user")
    public HashMap<Integer, String> getUserList() {
        return null;
    }
}
