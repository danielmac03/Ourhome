package com.ourhome.dao;

import com.ourhome.dto.Tokens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokensDAO extends JpaRepository<Tokens, Integer> {

    Tokens findByUser_idAndToken(int userId, String token);

}
