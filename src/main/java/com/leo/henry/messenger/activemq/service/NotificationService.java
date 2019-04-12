package com.leo.henry.messenger.activemq.service;


import com.leo.henry.messenger.activemq.model.NotificationEmail;

public class NotificationService {

	public void sendEmail(NotificationEmail email) {
		System.out.println("NotificationService send email " + email.toString());
	}

}
