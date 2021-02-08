package com.ourhome.controller;

import com.ourhome.dto.Notifications;
import com.ourhome.implemention.NotificationsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationsController {

	@Autowired
	NotificationsServiceImpl notificationsServiceImpl;

	@PreAuthorize("hasAnyAuthority('search', 'have', 'business')")
	@GetMapping("/user/{user_id}")
	public List<Notifications> listNotificationByUser(@PathVariable(name = "user_id") int user_id){
		return notificationsServiceImpl.listNotificationByUser(user_id);
	}

	@PreAuthorize("hasAnyAuthority('search', 'have', 'business')")
	@PostMapping()
	public Notifications saveNotification(@RequestBody Notifications notification) {
		return notificationsServiceImpl.saveNotification(notification);
	}

	@PreAuthorize("hasAnyAuthority('search', 'have', 'business')")
	@DeleteMapping("{id}")
	public void deleteNotification(@PathVariable(name = "id") int id) {
		notificationsServiceImpl.deleteNotification(id);
	}
	
}
