package com.benz.here.search.model;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class HttpResponse<T> {

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}

	private HttpStatus status;
	private String message;
	
	private T data;

	public HttpResponse(HttpStatus badRequest, String message, T data) {
		this.status = badRequest;
		this.message = message;
		this.data = data;

	}
}
