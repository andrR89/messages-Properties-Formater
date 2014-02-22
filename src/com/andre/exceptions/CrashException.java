package com.andre.exceptions;

public class CrashException extends RuntimeException {

	/** Serial. */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor.
	 * 
	 * @param message
	 */
	public CrashException(String message) {
		super(message);
	}
}
