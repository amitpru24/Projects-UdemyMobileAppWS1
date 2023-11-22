package com.appsdeveloperblog.app.ws.ui.model.response;

import java.time.LocalDate;

public class ErrorMessage {
	private LocalDate timestamp;
	private String message;
	
	public ErrorMessage() {
		super();
	}
	
	public ErrorMessage(LocalDate timestamp, String message) {
		super();
		this.timestamp = timestamp;
		this.message = message;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
