package com.example.cs;

public class MyException extends RuntimeException {

	private static final long serialVersionUID = 4396731217741748893L;
	private String statusCode;
	
	public MyException(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusCode() {
		return statusCode;
	}
}
