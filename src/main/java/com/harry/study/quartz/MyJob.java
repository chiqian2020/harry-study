package com.harry.study.quartz;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * MyJob
 *
 * @author harry
 * @date 2021/1/7 9:54 下午
 **/
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("do something");
    }

    public static void main(String[] args) {
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).build();
    }
}
