package com.leo.henry.messenger.activemq.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "queues")
public class ListOfActiveMqQueue {
	private List<ActiveMqQueue> queue;

	public List<ActiveMqQueue> getQueue() {
		return queue;
	}

	public void setQueue(List<ActiveMqQueue> queue) {
		this.queue = queue;
	}
}
