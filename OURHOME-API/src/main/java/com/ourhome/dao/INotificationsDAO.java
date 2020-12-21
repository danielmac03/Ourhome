package com.ourhome.dao;

import com.ourhome.dto.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface INotificationsDAO extends JpaRepository<Notifications, Integer>{

    List<Notifications> findByUser_id(int userId);

}
