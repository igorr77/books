package ru.otus.igorr.books.lesson18.repository.abstracts;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;

@DataMongoTest
@EnableConfigurationProperties
@ComponentScan({"ru.otus.igorr.books.lesson18.config", "ru.otus.igorr.books.lesson18.repository"})
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
public abstract class AbstractRepositoryTest {

}
