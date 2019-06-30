package ru.otus.igorr.books.lesson23.batch;

public interface JobService {
    void start(String jobName);
    void stop(String jobName);
    void restart(String jobName);

}
