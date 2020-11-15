package com.ourhome.service;

import com.ourhome.dao.INotificationsDAO;
import com.ourhome.dto.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationsServiceImpl implements INotificationsService {

	@Autowired
	INotificationsDAO iNotificationsDAO;
	
	@Override
	public List<Notifications> listNotifications() {
		return iNotificationsDAO.findAll();
	}

	@Override
	public Notifications saveNotification(Notifications notification) {
		return iNotificationsDAO.save(notification);
	}

	@Override
	public Notifications getNotification(int id) {
		return iNotificationsDAO.findById(id).get();
	}

	@Override
	public List<Notifications>  listNotificationByUser(int userId){
		return iNotificationsDAO.findByUser_id(userId);
	}

	@Override
	public Notifications updateNotification(Notifications notification) {
		return iNotificationsDAO.save(notification);
	}

	@Override
	public void deleteNotification(int id) {
		iNotificationsDAO.deleteById(id);
	}

}