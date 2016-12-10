package org.qa_automation.ui.atf.error;

public class FixtureError extends Exception {

	/**
	 * @author gtg716
	 * 
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
