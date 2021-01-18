package com.ourhome.implemention;

import com.ourhome.dao.ITokensDAO;
import com.ourhome.dto.Tokens;
import com.ourhome.service.ITokensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokensServiceImpl implements ITokensService {

    @Autowired
    ITokensDAO iTokensDAO;

    @Override
    public void saveToken(Tokens Token) {
        iTokensDAO.save(Token);
    }

    @Override
    public Tokens getToken(int userId, String token) {
        return iTokensDAO.findByUser_idAndToken(userId, token);
    }

    @Override
    public void deleteToken(int id) {
        iTokensDAO.deleteById(id);
    }

}