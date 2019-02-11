package com.example.mongodbgeopoc.model.common;

import org.springframework.hateoas.ResourceSupport;

public class RestResponse extends ResourceSupport {
	protected int statusCode;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
