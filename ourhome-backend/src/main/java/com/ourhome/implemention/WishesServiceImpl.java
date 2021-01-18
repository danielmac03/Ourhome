package com.ourhome.implemention;

import com.ourhome.dao.IWishesDAO;
import com.ourhome.dto.Wishes;
import com.ourhome.service.IWishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishesServiceImpl implements IWishesService {

    @Autowired
    IWishesDAO iWishesDAO;

    @Override
    public List<Wishes> searchWishesByUser(int user_id) {
        return iWishesDAO.findByUser_id(user_id);
    }

    @Override
    public Wishes searchWishesByUserAndHome(int user_id, int home_id) {
        return iWishesDAO.findByUser_idAndHome_id(user_id, home_id);
    }

    @Override
    public void saveWish(Wishes wish) {
        iWishesDAO.save(wish);
    }

    @Override
    public void deleteWishByUserAndHome(int user_id, int home_id) {
        iWishesDAO.deleteByUser_idAndHome_id(user_id, home_id);
    }

}