package ru.otus.igorr.books.lesson12.service.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson12.domain.genre.Genre;
import ru.otus.igorr.books.lesson12.dto.DtoConverter;
import ru.otus.igorr.books.lesson12.dto.GenreDto;
import ru.otus.igorr.books.lesson12.execptions.DeleteReferenceRecordException;
import ru.otus.igorr.books.lesson12.repository.author.AuthorRepository;
import ru.otus.igorr.books.lesson12.repository.book.BookRepository;
import ru.otus.igorr.books.lesson12.repository.genre.GenreRepository;

import java.util.List;


@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final DtoConverter<Genre, GenreDto> converter;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository,
                            AuthorRepository authorRepository,
                            BookRepository bookRepository,
                            @Qualifier("genreConverter") DtoConverter converter) {
        this.genreRepository = genreRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.converter = converter;
    }


    @Override
    public GenreDto getById(String id) {
        return converter.convert(genreRepository.findById(id).orElse(Genre.empty()));
    }

    @Override
    public String add(GenreDto dto) {
        Genre genre = genreRepository.save(converter.fill(dto));
        return genre.getId();
    }

    @Override
    public void delete(String id) {
        if (!checkForDelete(id)) {
            throw new DeleteReferenceRecordException(id);
        }
        genreRepository.deleteById(id);
    }

    @Override
    public void delete(GenreDto dto) {
        if (!checkForDelete(dto.getId())) {
            throw new DeleteReferenceRecordException(dto.getId());
        }
        genreRepository.delete(converter.fill(dto));
    }

    @Override
    public List<GenreDto> getList() {
        return converter.convertList(genreRepository.findAll());
    }

    @Override
    public List<GenreDto> getListByName(String mask) {
        List<Genre> genreList = genreRepository.findByNameLike(mask);
        return converter.convertList(genreList);
    }

    private boolean checkForDelete(String genreId) {
        return bookRepository.findByGenreId(genreId).size() == 0
                && authorRepository.findByGenreId(genreId).size() == 0;
    }

}
