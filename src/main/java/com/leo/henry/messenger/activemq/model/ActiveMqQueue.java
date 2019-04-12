package com.leo.henry.messenger.activemq.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="queue")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActiveMqQueue {

	@XmlAttribute
	private String name;
	private Stats stats;

	public String getName() {
		return name;
	}

	public Stats getStats() {
		return stats;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}
}
