package com.ourhome.service;

import com.ourhome.dto.Wishes;

import java.util.List;

public interface IWishesService {

    public List<Wishes> searchWishesByUser(int user_id);

    public Wishes searchWishesByUserAndHome(int user_id, int home_id);

    public void saveWish(Wishes wish);

    public void deleteWishByUserAndHome(int user_id, int home_id);

}
