package com.ourhome.controller;

import com.ourhome.dto.Notifications;
import com.ourhome.service.NotificationsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationsController {

	@Autowired
	NotificationsServiceImpl NotificationsServiceImpl;
	
	@GetMapping()
	public List<Notifications> listNotifications(){
		return NotificationsServiceImpl.listNotifications();
	}

	@GetMapping("/{id}")
	public Notifications searchNotification(@PathVariable(name = "id") int id) {
		Notifications Notification = new Notifications();		
		Notification = NotificationsServiceImpl.getNotification(id);
		
		return Notification;
	}

	@GetMapping("/user/{user_id}")
	public List<Notifications> listNotificationByUser(@PathVariable(name = "user_id") int user_id){
		return NotificationsServiceImpl.listNotificationByUser(user_id);
	}

	@PostMapping()
	public Notifications saveNotification(@RequestBody Notifications notification) {
		return NotificationsServiceImpl.saveNotification(notification);
	}

	@PutMapping("/{id}")
	public Notifications updateNotification(@PathVariable(name = "id") int id, @RequestBody Notifications notification) {
		Notifications NotificationSelected = new Notifications();
		Notifications NotificationUpdated = new Notifications();
		
		NotificationSelected = NotificationsServiceImpl.getNotification(id);
		
		NotificationSelected.setUser(notification.getUser());
		NotificationSelected.setContent(notification.getContent());
		NotificationSelected.setCreatedAt(notification.getCreatedAt());

		NotificationUpdated = this.NotificationsServiceImpl.updateNotification(NotificationSelected);
		
		return NotificationUpdated;
	}
	
	@DeleteMapping("{id}")
	public void deleteNotification(@PathVariable(name="id") int id) {
		NotificationsServiceImpl.deleteNotification(id);
	}
	
}
