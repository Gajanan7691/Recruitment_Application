package com.inn.recruitment.customexception;

public class RestException  extends Exception{

	public RestException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RestException(String message, Throwable cause) {
		super(message, cause);
	}

	public RestException(String message) {
		super(message);

	}

	public RestException(Throwable cause) {
		super(cause);
	}
	


}
