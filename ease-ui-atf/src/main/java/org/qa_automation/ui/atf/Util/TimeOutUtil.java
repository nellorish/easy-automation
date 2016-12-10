/**
 * 
 */
package org.qa_automation.ui.atf.Util;

import java.util.Date;

/**
 * @author gtg716
 *
 */
public class TimeOutUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long POLLING_INTERVAL_MILLI_SEC = 15;
		Date time = new Date();
		int Grace_retry=0;
		long diff_times=0;
		while(diff_times <=1000){
			diff_times = new Date().getTime()/1000 % 60-time.getTime()/1000 % 60;
			
			if(diff_times>=POLLING_INTERVAL_MILLI_SEC){
				break;
			}
			System.out.println(" Get the the Milli Seconds :"+time.getTime());
			System.out.println(" diff_times :"+diff_times);
			
		}

	}

}
