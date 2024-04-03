package com.wrapper.demo.entity;

public class CustomMessage {
	
	private String messageId;
	
	private String message;
	
	private String messageDate;

	public CustomMessage(String messageId, String message, String messageDate) {
		super();
		this.messageId = messageId;
		this.message = message;
		this.messageDate = messageDate;
	}

	public CustomMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CustomMessage [messageId=" + messageId + ", message=" + message + ", messageDate=" + messageDate + "]";
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}
	
	

}
