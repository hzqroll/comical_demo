package com.roll.comical.console.business.testLog;

import org.apache.log4j.component.scheduler.Job;
import org.apache.velocity.tools.config.Data;
import org.springframework.scheduling.quartz.JobDetailAwareTrigger;


/**
 * @author zongqiang.hao
 */
public class SimpleJob implements Job {
		public void execute(){
			System.out.print("1"+new Data());
		}

		public static void main(String args[]){
			/*JobDetailAwareTrigger jobDetailAwareTrigger = new JobDetailAwareTrigger() {
				@Override
				public org.quartz.JobDetail getJobDetail() {
					return null;
				}
			};*/
		}
}
