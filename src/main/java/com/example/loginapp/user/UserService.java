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
        // 1. 동일한 username이 있는지 확인
        if (reqDTO.getUsername().equals(reqDTO.getUsername())) throw new RuntimeException("동일한 아이디가 있습니다.");

        userRepository.save(reqDTO.toEntity());
    }

    public User login(UserRequest.LoginDTO reqDTO) {
        User user = userRepository.findByUsername(reqDTO.getUsername());

        // 1. 등록된 username이 있는지 확인
        if (user == null) throw new RuntimeException("아이디 혹은 비밀번호가 틀렸습니다.");
        // 2. password가 맞는지 확인
        if (!user.getPassword().equals(reqDTO.getPassword())) {
            throw new RuntimeException("아이디 혹은 비밀번호가 틀렸습니다.");
        }
        return user;
    }

    @Transactional
    public User update(UserRequest.UpdateDTO reqDTO, Integer sessionId) {
        User userPS = userRepository.findById(sessionId);

        // 1. sessionId가 없을 때
        if (userPS == null) throw new RuntimeException("자원이 없습니다.");

        userPS.update(reqDTO.getPassword());
        return userPS;
    }
}

