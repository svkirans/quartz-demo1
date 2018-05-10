/**
 * 
 */
package com.codingsquare.quartzdemo;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author vsurapaneni
 *
 */
public class SampleJob implements Job {

	/**
	 * 
	 */
	public SampleJob() {
	}

	/* (non-Javadoc)
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Completed execution at :"+(new Date()).toString());
	}

}
