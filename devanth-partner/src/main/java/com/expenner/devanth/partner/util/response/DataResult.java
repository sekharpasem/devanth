package com.expenner.devanth.partner.util.response;

import java.util.List;

import com.expenner.devanth.partner.util.AppConstants;

/**
 * wraps the data model,status code,message
 * 
 * @author Sekhar
 * @param <T>
 * 
 */
public class DataResult<T> {
	public boolean successful = false;
	public String message = "";
	public int statusCode = AppConstants.StatusCodes.BAD_REQUEST.getCode();
	public T entity;
	public List<T> entities;

	public DataResult(boolean successful, String message, int statusCode) {
		this.successful = successful;
		this.message = message;
		this.statusCode = statusCode;
	}

	public DataResult(boolean successful, String message, int statusCode, List<T> entities) {
		this.successful = successful;
		this.message = message;
		this.statusCode = statusCode;
		this.entities = entities;
	}

	public DataResult(boolean successful, String message, int statusCode, T entity) {
		this.successful = successful;
		this.message = message;
		this.statusCode = statusCode;
		this.entity = entity;
	}

}
