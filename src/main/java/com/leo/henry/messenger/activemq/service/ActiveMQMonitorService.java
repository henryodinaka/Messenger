package com.leo.henry.messenger.activemq.service;

import com.leo.henry.messenger.activemq.model.ActiveMqQueue;
import com.leo.henry.messenger.activemq.model.ListOfActiveMqQueue;
import com.leo.henry.messenger.activemq.model.NotificationEmail;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class ActiveMQMonitorService {

	private ActiveMqQueueTransformer transformer = new ActiveMqQueueTransformer();
	private NotificationService notService = new NotificationService();

	@SuppressWarnings("resource")
	public void monitorAndNotify(String brokerUrl, String username, String password, int maxPendingMessageLimit) {
		System.out.println("monitorAndNotify starts for " + brokerUrl);
		NotificationEmail email = dummyEmail();
		InputStream xmlFeedData = readXmlFeeds(brokerUrl, username, password);

		ListOfActiveMqQueue activeMqXmlData = transformer.convertFromInputStream(xmlFeedData);
		if (activeMqXmlData != null) {
			for (ActiveMqQueue queue : activeMqXmlData.getQueue()) {
				if (queue.getStats().getConsumerCount() == 0) {				
					email.setSubject("Must check activeMQ, queue: " + queue.getName() + " has no consumer.");
					notService.sendEmail(email);
				}
				else{
					int pendingMessageCounts = queue.getStats().getSize() - queue.getStats().getEnqueueCount();
					if( pendingMessageCounts > maxPendingMessageLimit){
						email.setSubject("Must check activeMQ, queue: " + queue.getName() + " has large pending message. ");
						notService.sendEmail(email);
					}
				}
			}
		}	
		System.out.println("monitorAndNotify completes for " + brokerUrl);
	}

	private InputStream readXmlFeeds(String brokerUrl, String username, String password) {
		try {
			URL url = new URL(brokerUrl);
			URLConnection uc = url.openConnection();

			String userpass = username + ":" + password;
			String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes());

			uc.setRequestProperty("Authorization", basicAuth);

			return uc.getInputStream();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	private NotificationEmail dummyEmail() {
		NotificationEmail noConsumerEmail = new NotificationEmail();
		noConsumerEmail.setFromAddress("monitorApp@noreply.com");
		noConsumerEmail.setToAddress("henry.onah@upperlink.ng");
		noConsumerEmail.setBody("My first active MQ app");
		return noConsumerEmail;
	}
}
