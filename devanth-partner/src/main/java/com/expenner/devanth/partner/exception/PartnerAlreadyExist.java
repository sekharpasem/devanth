package com.expenner.devanth.partner.exception;

/**
 * 
 * @author spasem
 *
 */
public class PartnerAlreadyExist extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errorCode;

	public PartnerAlreadyExist() {

	}

	public PartnerAlreadyExist(String message) {
		super(message);
	}

	public PartnerAlreadyExist(String message, int errorCode) {
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
