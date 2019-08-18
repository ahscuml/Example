package com.ahscuml.quartz.quartzJob;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.quartz.JobBuilder.newJob;

/**
 * @author ahscuml
 * @date 2019/8/17
 * @time 16:20
 */
public class QuartzTest {
    public static Logger logger = LoggerFactory.getLogger(QuartzTest.class);

    public static void main(String[] args) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // define the job and tie it to our HelloJob class
            JobDetail job = newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .build();

            scheduler.start();
            logger.info("执行Job");
            scheduler.shutdown();
        } catch (SchedulerException schedulerException) {
            schedulerException.printStackTrace();
        }
    }
}
