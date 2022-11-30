package com.os.exception;

import java.time.LocalDateTime;

public class MyErrorDetails {
	private LocalDateTime time;
	private String message;
	private String description;
	
	public MyErrorDetails() {
		// TODO Auto-generated constructor stub
	}

	public MyErrorDetails(LocalDateTime time, String message, String description) {
		super();
		this.time = time;
		this.message = message;
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "MyErrorDetails [time=" + time + ", message=" + message + ", description=" + description + "]";
	}
	
	
}
