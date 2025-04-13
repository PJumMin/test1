package com.example.loginapp.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoardRepository {
    private final EntityManager em;

    public List<Board> findAll() {
        Query query = em.createQuery("select b from Board b ORDER BY id", Board.class);
        List<Board> boardList = query.getResultList();
        return boardList;
    }
}
