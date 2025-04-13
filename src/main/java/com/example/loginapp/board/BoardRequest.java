package com.example.loginapp.board;

import com.example.loginapp.user.User;
import lombok.Data;

public class BoardRequest {

    @Data
    public static class SaveDTO {
        private String title;
        private String content;
        private String isPublic;

        public Board toEntity(User user) {
            return Board.builder()
                    .title(title)
                    .content(content)
                    .user(user) // user객체 필요
                    .build();
        }
    }
}
