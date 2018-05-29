package com.expenner.devanth.partner.exception;

public class PartnerNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errorCode;

	public PartnerNotFoundException() {

	}

	public PartnerNotFoundException(String message) {
		super(message);
	}

	public PartnerNotFoundException(String message, int errorCode) {
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
