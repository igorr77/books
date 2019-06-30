package ru.otus.igorr.books.lesson23.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class JobServiceImpl implements JobService {

    private JobLauncher jobLauncher;
    private JobRegistry jobRegistry;
    private JobExecution jobExecution;

    @Autowired
    public JobServiceImpl(JobLauncher jobLauncher, JobRegistry jobRegistry) {
        this.jobLauncher = jobLauncher;
        this.jobRegistry = jobRegistry;
    }

    @Override
    public List<String> list() {
        return new ArrayList(jobRegistry.getJobNames());
    }

    @Override
    public void start(String jobName) {
        try {
            Job job = jobRegistry.getJob(jobName);
            jobExecution = jobLauncher.run(job, new JobParameters());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop(String jobName) {
        try {
            Job job = jobRegistry.getJob(jobName);
        } catch (NoSuchJobException e) {
            e.printStackTrace();
        }
        /*
        if (jobExecution != null && jobExecution.isRunning()) {
            jobExecution.stop();
            while (jobExecution.isStopping()) {
                System.out.print(".");
            }
            System.out.println(jobExecution.getEndTime());
        }

                 */

    }

    @Override
    public void restart(String jobName) {
        /*
        if(jobExecution != null && !jobExecution.isRunning()){
            try {

                jobExecution = jobLauncher.run(job, new JobParameters());
            } catch (JobExecutionAlreadyRunningException e) {
                e.printStackTrace();
            } catch (JobRestartException e) {
                e.printStackTrace();
            } catch (JobInstanceAlreadyCompleteException e) {
                e.printStackTrace();
            } catch (JobParametersInvalidException e) {
                e.printStackTrace();
            }
        }

         */
    }


}
