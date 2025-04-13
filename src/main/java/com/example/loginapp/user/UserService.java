package com.example.loginapp.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void join(UserRequest.JoinDTO reqDTO) {
        userRepository.save(reqDTO.toEntity());
    }

    public User login(UserRequest.LoginDTO reqDTO) {
        User user = userRepository.findByUsername2(reqDTO.getUsername());
        return user;
    }
}
