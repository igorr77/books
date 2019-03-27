package ru.otus.igorr.books.lesson06;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.igorr.books.lesson06.config.MessagesProps;


//@Configuration
//@EnableConfigurationProperties(MessagesProps.class)
public class MessageSource {

    private static final Logger LOG = LoggerFactory.getLogger(MessageSource.class);

    //@Bean
    public org.springframework.context.MessageSource messageSource(MessagesProps props) {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename(props.getBundle());
        ms.setDefaultEncoding("UTF-8");
        LOG.debug("===> {}", props.getBundle());
        return ms;
    }

}
