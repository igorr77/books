package ru.otus.igorr.books.lesson23.batch;

import java.util.List;

public interface JobService {
    List<String> list();
    void start(String jobName);
    void stop(String jobName);
    void restart(String jobName);

}
