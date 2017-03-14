package org.sinaf.tpFileRouge.exception;

public class TechniqueException extends Exception {

	private static final long serialVersionUID = 1L;

	public TechniqueException(String message, Throwable cause) {
		super(message, cause);
	}

	public TechniqueException(String message) {

		super(message);
	}

}
