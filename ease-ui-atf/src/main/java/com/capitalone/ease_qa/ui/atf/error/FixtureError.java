package com.capitalone.ease_qa.ui.atf.error;

public class FixtureError extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FixtureError(String errormsg) {
		// TODO Auto-generated constructor stub
		super(errormsg);
	}

	public FixtureError(String errorStmt, Exception e) {
		
		super(errorStmt, e);
		// TODO Auto-generated constructor stub
	}

	public FixtureError() {
		// TODO Auto-generated constructor stub
	}

}
