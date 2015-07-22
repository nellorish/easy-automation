package com.capitalone.ease_qa.ui.atf.error;

public class TimeOutException extends FixtureError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TimeOutException(String errorStmt, Exception e) {
		super(errorStmt, e);
		
	}

	
}
