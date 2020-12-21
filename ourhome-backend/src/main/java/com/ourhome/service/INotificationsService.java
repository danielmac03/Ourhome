package com.ourhome.service;

import com.ourhome.dto.Notifications;

import java.util.List;

public interface INotificationsService {

	public Notifications saveNotification(Notifications notification);
	
	public Notifications getNotification(int id);

	public List<Notifications> listNotificationByUser(int userId);

	public void deleteNotification(int id);
		
}