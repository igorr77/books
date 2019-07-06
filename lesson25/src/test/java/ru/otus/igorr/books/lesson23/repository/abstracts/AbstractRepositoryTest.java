package ru.otus.igorr.books.lesson25.repository.abstracts;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;

@DataMongoTest
@EnableConfigurationProperties
@ComponentScan({"ru.otus.igorr.books.lesson25.config", "ru.otus.igorr.books.lesson25.repository"})
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
public abstract class AbstractRepositoryTest {

}
