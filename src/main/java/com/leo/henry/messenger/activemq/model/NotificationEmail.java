package com.leo.henry.messenger.activemq.model;

public class NotificationEmail {
	private String fromAddress;
	private String toAddress;
	private String subject;
	private String body;

	public String getFromAddress() {
		return fromAddress;
	}

	public String getToAddress() {
		return toAddress;
	}

	public String getSubject() {
		return subject;
	}

	public String getBody() {
		return body;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	@Override
	public String toString(){
		return "EmailNotification [ toAddress=" + toAddress + ", subject=" + subject + ", body=" + body + "]";
	}

}
