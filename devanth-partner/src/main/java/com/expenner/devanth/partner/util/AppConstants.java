package com.expenner.devanth.partner.util;

public class AppConstants {

	/**
	 * DATA RESULT STATUS CODES
	 */
	public enum StatusCodes {
		NO_CONTENT(204), OK(200), CREATED(201), INVALID_REQUEST(210), UNAUTHORIZED(401), BAD_REQUEST(
				400), INTERNAL_SERVER_ERROR(500);
		private final int code;

		private StatusCodes(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
	}
}
