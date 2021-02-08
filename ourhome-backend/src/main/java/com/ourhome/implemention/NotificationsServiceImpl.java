package com.ourhome.implemention;

import com.ourhome.dao.INotificationsDAO;
import com.ourhome.dto.Notifications;
import com.ourhome.service.INotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationsServiceImpl implements INotificationsService {

	@Autowired
	INotificationsDAO iNotificationsDAO;

	@Override
	public Notifications saveNotification(Notifications notification) {
		return iNotificationsDAO.save(notification);
	}

	@Override
	public List<Notifications>  listNotificationByUser(int userId){
		return iNotificationsDAO.findByUser_id(userId);
	}

	@Override
	public void deleteNotification(int id) {
		iNotificationsDAO.deleteById(id);
	}

}