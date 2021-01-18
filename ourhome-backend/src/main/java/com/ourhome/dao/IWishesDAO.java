package com.ourhome.dao;

import com.ourhome.dto.Wishes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IWishesDAO extends JpaRepository<Wishes, Integer> {

    List<Wishes> findByUser_id(int user_id);

    Wishes findByUser_idAndHome_id(int user_id, int home_id);

    void deleteByUser_idAndHome_id(int user_id, int home_id);

}
