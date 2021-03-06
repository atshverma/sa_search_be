package com.sas.sanction.dto;

public class Result {
	
	private String status;

	private String message;
	
	private Object data;
	
	public Result() {
		
	}

	public Result(String status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}


	public Result(String status, String message) {
		this.status = status;
		this.message = message;
	}


	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
	
	

}
