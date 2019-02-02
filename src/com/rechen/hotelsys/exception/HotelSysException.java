/**
 * 
 */
package com.rechen.hotelsys.exception;

/**
 * @author Re.chen
 *
 */
public class HotelSysException extends RuntimeException {

	/**
	 * 
	 */
	public HotelSysException() {
	}

	/**
	 * @param message
	 */
	public HotelSysException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public HotelSysException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public HotelSysException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public HotelSysException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
