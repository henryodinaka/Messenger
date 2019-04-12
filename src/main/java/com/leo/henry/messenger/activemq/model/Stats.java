package com.leo.henry.messenger.activemq.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Stats {

	@XmlAttribute
	private Integer size;
	@XmlAttribute
	private int consumerCount;
	@XmlAttribute
	private int enqueueCount;
	@XmlAttribute
	private int dequeueCount;

	public Integer getSize() {
		return size;
	}

	public int getConsumerCount() {
		return consumerCount;
	}

	public int getEnqueueCount() {
		return enqueueCount;
	}

	public int getDequeueCount() {
		return dequeueCount;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public void setConsumerCount(int consumerCount) {
		this.consumerCount = consumerCount;
	}

	public void setEnqueueCount(int enqueueCount) {
		this.enqueueCount = enqueueCount;
	}

	public void setDequeueCount(int dequeueCount) {
		this.dequeueCount = dequeueCount;
	}
}
