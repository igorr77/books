package ru.otus.igorr.books.lesson06;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.igorr.books.lesson06.config.MessagesProps;


@Configuration
@EnableConfigurationProperties(MessagesProps.class)
public class MSource {

    private static final Logger LOG = LoggerFactory.getLogger(MSource.class);

    @Bean("mSource")
    public org.springframework.context.MessageSource messageSource(MessagesProps props) {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename(props.getBundle());
        ms.setDefaultEncoding("UTF-8");
        LOG.debug("===> {}", props.getBundle());
        return ms;
    }

}
