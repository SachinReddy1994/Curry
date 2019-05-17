/**
 @author syerrana
 This class throws exception at runtime. 
 */
package com.cg.currypoint.exception;

public class VendorNotFoundException extends RuntimeException {

	public VendorNotFoundException() {
		super();
	}

	public VendorNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public VendorNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public VendorNotFoundException(String message) {
		super(message);
	}

	public VendorNotFoundException(Throwable cause) {
		super(cause);
	}

}
