package ru.otus.igorr.books.lesson25.service.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson25.domain.mongo.book.Note;
import ru.otus.igorr.books.lesson25.repository.mongo.book.NoteRepository;

@Service
@Slf4j
public class NoteFilter {
    private final DirectChannel moderator;
    private final DirectChannel admin;
    private final NoteRepository repository;

    @Autowired
    public NoteFilter(@Qualifier("moderator") DirectChannel moderator,
                      @Qualifier("administrator") DirectChannel admin,
                      NoteRepository repository) {
        this.moderator = moderator;
        this.admin = admin;
        this.repository = repository;

        this.moderator.subscribe(this::noteFiltering);
        this.admin.subscribe(this::noteDelete);
    }

    private void noteFiltering(Message message) {
        Note note = (Note) message.getPayload();
        LOG.debug("Start validate note: " + note);

        new Thread(
                () -> {
                    try {
                        if (note.getNote().toLowerCase().contains("редиска")) {
                            Thread.sleep(10000);
                            Message<Note> messageFail = MessageBuilder
                                    .fromMessage(message)
                                    .build();
                            admin.send(messageFail);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

        ).start();
        LOG.debug("End validate note");

    }

    private void noteDelete(Message message) {
        Note note = (Note) message.getPayload();
        LOG.debug("--- Administrator deleting note: " + note.getId() + " " + note.getNote());
        repository.deleteById(note.getId());
    }
}
