package com.example.helpers;

public enum ApiStatusCode{
	
	STATUS400("400"),
    STATUS401("401"),
    STATUS405("405"),
    STATUS406("406"),
    STATUS200("200"),
    STATUS404("404"),
    STATUS403("403"),
    STATUS408("408"),
    STATUS500("500");

	protected String statusCode;
	
	private ApiStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusCode() {
		return statusCode;
	}
	
}
