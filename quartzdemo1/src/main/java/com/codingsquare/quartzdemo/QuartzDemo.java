/**
 * 
 */
package com.codingsquare.quartzdemo;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;

/**
 * @author vsurapaneni
 *
 */
public class QuartzDemo {

	/**
	 * 
	 */
	public QuartzDemo() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			SchedulerFactory sf = new org.quartz.impl.StdSchedulerFactory();
			Scheduler scheduler = sf.getScheduler();
			scheduler.start();
			
			//defining a job and linking it to the SampleJob we created
			  JobDetail job = newJob(SampleJob.class)
			      .withIdentity("sampleJob", "group1")
			      .build();
			  //defining a trigger to run every 10 seconds
			  Trigger trigger = newTrigger()
			      .withIdentity("sampleTrigger", "group1")
			      .startNow()
			      .withSchedule(simpleSchedule()
			          .withIntervalInSeconds(10)
			          .repeatForever())            
			      .build();

			  // schedule the job using the trigger
			  scheduler.scheduleJob(job, trigger);
			  
			  
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
	}

}
