package com.expenner.devanth.exception;

/**
 * 
 * @author spasem
 *
 */
public class UserAlreadyExist extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errorCode;

	public UserAlreadyExist() {

	}

	public UserAlreadyExist(String message) {
		super(message);
	}

	public UserAlreadyExist(String message, int errorCode) {
		super(message);
		this.setErrorCode(errorCode);
	}

	public int getErrorCode() {
		return errorCode;
	}

	private void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
