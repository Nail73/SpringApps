package com.example.groupChat.services;


import com.example.groupChat.models.User;
import com.example.groupChat.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.HashMap;
import java.util.Optional;

@Component
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public HashMap<String, Boolean> auth(String name) {
        HashMap<String, Boolean> result = new HashMap<>();
        if (!Strings.isNotEmpty(name)) {
            result.put("result", false);
            return result;
        }
        String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
        User user = new User();
        user.setName(name);
        user.setSessionId(sessionId);
        userRepository.save(user);
        result.put("result", true);
        return result;
    }

    public HashMap<String, Boolean> isAuth() {
        HashMap<String, Boolean> result = new HashMap<>();
        String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
        Optional<User> userOpt = userRepository.findBySessionId(sessionId);
        result.put("result", userOpt.isPresent());
        return result;
    }
}
