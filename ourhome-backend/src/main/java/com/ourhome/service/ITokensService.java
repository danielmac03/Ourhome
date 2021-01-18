package com.ourhome.service;

import com.ourhome.dto.Tokens;

public interface ITokensService {

    public void saveToken(Tokens Token);

    public Tokens getToken(int userId, String token);

    public void deleteToken(int id);

}