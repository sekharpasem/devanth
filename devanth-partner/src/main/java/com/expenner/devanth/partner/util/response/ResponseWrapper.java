package com.expenner.devanth.partner.util.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.expenner.devanth.partner.util.AppConstants.StatusCodes;

/**
 * Common Response wrapper
 * <li>Wraps response related data into {@code DataResult}</li>
 * <li>Wraps {@code DataResult} into {@code ResponseEntity}</li>
 * 
 * @author Sekhar
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ResponseWrapper {

	public static <T> ResponseEntity<DataResult> wrapBadRequestResponse(String message) {
		return new ResponseEntity<DataResult>(new DataResult(false, message, StatusCodes.BAD_REQUEST.getCode()),
				HttpStatus.BAD_REQUEST);

	}

	public static <T> ResponseEntity<DataResult> wrapBadRequestResponse(String message, int customStatusCode) {
		return new ResponseEntity<DataResult>(new DataResult(false, message, customStatusCode), HttpStatus.BAD_REQUEST);

	}

	public static <T> ResponseEntity<DataResult> wrapBadRequestResponse(String message, T entity,
			int customStatusCode) {
		return new ResponseEntity<DataResult>(new DataResult(false, message, customStatusCode, entity),
				HttpStatus.BAD_REQUEST);

	}

	public static <T> ResponseEntity<DataResult> wrapBadRequestResponse(T entity) {
		return new ResponseEntity<DataResult>(
				new DataResult(false, "failed", StatusCodes.BAD_REQUEST.getCode(), entity), HttpStatus.BAD_REQUEST);

	}

	public static <T> ResponseEntity<DataResult> wrapBadRequestResponse(T entity, int customStatusCode) {
		return new ResponseEntity<DataResult>(new DataResult(false, "failed", customStatusCode, entity),
				HttpStatus.BAD_REQUEST);

	}

	/**
	 * 
	 * Success response
	 * <li>Creates {@code DataResult} object by wrapping parameters into it.</li>
	 * <li>Creates {@code ResponseEntity} object by wrapping {@code DataResult},
	 * {@code HttpStatus} into it.</li>
	 * <li>sets the {@code HttpStatus} value as customStatusCode</li>
	 * 
	 * @param <T>
	 * 
	 * @param entity
	 * 
	 * @return ResponseEntity<DataResult>
	 */
	public static <T> ResponseEntity<DataResult> wrapCreatedResponse(T entity) {
		return new ResponseEntity<DataResult>(new DataResult(true, "Success", StatusCodes.CREATED.getCode(), entity),
				HttpStatus.CREATED);

	}

	/**
	 * <li>Invalid input response</li>
	 * <li>Creates {@code DataResult} object by wrapping parameters into it.</li>
	 * <li>Creates {@code ResponseEntity} object by wrapping {@code DataResult},
	 * {@code HttpStatus} into it.</li>
	 * <li>sets the {@code HttpStatus} value as customStatusCode</li>
	 * 
	 * @param successful
	 * @param result
	 * @param httpStatus
	 * @return
	 * @return ResponseEntity<DataResult>
	 */
	public static ResponseEntity<DataResult> wrapInvalidInputResponse() {
		return new ResponseEntity<DataResult>(
				new DataResult(false, "Invalid input, Mandatory fields are missing", StatusCodes.BAD_REQUEST.getCode()),
				HttpStatus.BAD_REQUEST);
	}

	/**
	 * No content response
	 * <li>Creates {@code DataResult} object by wrapping parameters into it.</li>
	 * <li>Creates {@code ResponseEntity} object by wrapping {@code DataResult},
	 * {@code HttpStatus} into it.</li>
	 * <li>sets the {@code HttpStatus} value as customStatusCode</li>
	 * 
	 * @param entities
	 * 
	 * @return ResponseEntity<DataResult>
	 */
	public static ResponseEntity<DataResult> wrapNoContentResponse() {
		return new ResponseEntity<DataResult>(
				new DataResult(true, "NO CONTENT", StatusCodes.NO_CONTENT.getCode(), new ArrayList<Object>(1)),
				HttpStatus.OK);
	}

	/***
	 * <li>Creates {@code DataResult} object by wrapping parameters into it.</li>
	 * <li>Creates {@code ResponseEntity} object by wrapping {@code DataResult},
	 * {@code HttpStatus} into it.</li>
	 * <li>sets the {@code HttpStatus} value as customStatusCode</li>
	 * 
	 * @param successful
	 * @param result
	 * @param httpStatus
	 * @param entity
	 * @return
	 */
	public static ResponseEntity<DataResult> wrapResponse(boolean successful, String message, HttpStatus httpStatus,
			Object entity) {
		return new ResponseEntity<DataResult>(new DataResult(successful, message, httpStatus.value(), entity),
				httpStatus);
	}

	/***
	 * <li>Creates {@code DataResult} object by wrapping parameters into it.</li>
	 * <li>Creates {@code ResponseEntity} object by wrapping {@code DataResult},
	 * {@code HttpStatus} into it.</li>
	 * 
	 * @param successful
	 * @param result
	 * @param customStatusCode
	 * @param httpStatus
	 * @return
	 */
	public static ResponseEntity<DataResult> wrapResponse(boolean successful, String message, int customStatusCode,
			HttpStatus httpStatus) {
		return new ResponseEntity<DataResult>(new DataResult(successful, message, customStatusCode), httpStatus);
	}

	/**
	 * 
	 * Success response
	 * <li>Creates {@code DataResult} object by wrapping parameters into it.</li>
	 * <li>Creates {@code ResponseEntity} object by wrapping {@code DataResult},
	 * {@code HttpStatus} into it.</li>
	 * <li>sets the {@code HttpStatus} value as customStatusCode</li>
	 * 
	 * @param <T>
	 * 
	 * @param entities
	 * 
	 * @return ResponseEntity<DataResult>
	 */
	public static <T> ResponseEntity<DataResult> wrapSuccessResponse(List<T> entities) {
		return new ResponseEntity<DataResult>(new DataResult(true, "Success", StatusCodes.OK.getCode(), entities),
				HttpStatus.OK);
	}

	/**
	 * Success response
	 * <li>Creates {@code DataResult} object by wrapping parameters into it.</li>
	 * <li>Creates {@code ResponseEntity} object by wrapping {@code DataResult},
	 * {@code HttpStatus} into it.</li>
	 * <li>sets the {@code HttpStatus} value as customStatusCode</li>
	 * 
	 * @param message
	 * 
	 * @return ResponseEntity<DataResult>
	 */
	public static ResponseEntity<DataResult> wrapSuccessResponse(String message) {
		return new ResponseEntity<DataResult>(new DataResult(true, message, StatusCodes.OK.getCode()), HttpStatus.OK);
	}

	/**
	 * 
	 * Success response
	 * <li>Creates {@code DataResult} object by wrapping parameters into it.</li>
	 * <li>Creates {@code ResponseEntity} object by wrapping {@code DataResult},
	 * {@code HttpStatus} into it.</li>
	 * <li>sets the {@code HttpStatus} value as customStatusCode</li>
	 * 
	 * @param <T>
	 * 
	 * @param entity
	 * 
	 * @return ResponseEntity<DataResult>
	 */
	public static <T> ResponseEntity<DataResult> wrapSuccessResponse(T entity) {
		return new ResponseEntity<DataResult>(new DataResult(true, "Success", StatusCodes.OK.getCode(), entity),
				HttpStatus.OK);

	}

	/**
	 * un authorized response
	 * <li>Creates {@code DataResult} object by wrapping parameters into it.</li>
	 * <li>Creates {@code ResponseEntity} object by wrapping {@code DataResult},
	 * {@code HttpStatus} into it.</li>
	 * <li>sets the {@code HttpStatus} value as customStatusCode</li>
	 * 
	 * @param entities
	 * 
	 * @return ResponseEntity<DataResult>
	 */
	public static ResponseEntity<DataResult> wrapUnauthorizedResponse() {
		return new ResponseEntity<DataResult>(
				new DataResult(false, "Unauthorized request", StatusCodes.UNAUTHORIZED.getCode()),
				HttpStatus.UNAUTHORIZED);
	}
}
