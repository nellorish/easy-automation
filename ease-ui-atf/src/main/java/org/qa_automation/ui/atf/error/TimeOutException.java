package org.qa_automation.ui.atf.error;

public class TimeOutException extends FixtureError {

	/**
	 * @author gtg716
	 * 
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TimeOutException(String errorStmt, Exception e) {
		super(errorStmt, e);
		
	}

	
}
