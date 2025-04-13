package com.example.loginapp.user;

import lombok.Data;

public class UserRequest {

    @Data
    public static class JoinDTO {
        private String username;
        private String password;

        public User toEntity() {
            return User.builder()
                    .username(username)
                    .password(password)
                    .build();
        }
    }

    @Data
    public static class LoginDTO {
        private String username;
        private String password;
    }

    @Data
    public static class UpdateDTO {
        private String username;
        private String password;
    }
}
