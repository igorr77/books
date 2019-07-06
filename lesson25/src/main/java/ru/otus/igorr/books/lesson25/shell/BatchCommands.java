package ru.otus.igorr.books.lesson25.shell;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@Slf4j
@ShellComponent
public class BatchCommands {


    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private JobRegistry jobRegistry;
    private JobExecution jobExecution;


    @ShellMethod(key = "start", value = "Start Job")
    public void start(@ShellOption("--name") String jobName) {

        LOG.debug("*** JobStart: " + jobName);

        try {
            Job job = jobRegistry.getJob(jobName);
            jobExecution = jobLauncher.run(job, new JobParameters());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @ShellMethod(key = "listJob", value = "Job's list")
    public void listJob() {

        LOG.debug("*** Job's list: ");

        jobRegistry.getJobNames().stream()
                .forEach(System.out::println);

    }


}
