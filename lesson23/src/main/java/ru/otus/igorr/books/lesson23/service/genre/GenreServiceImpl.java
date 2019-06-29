package ru.otus.igorr.books.lesson23.service.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson23.domain.genre.Genre;
import ru.otus.igorr.books.lesson23.dto.DtoConverter;
import ru.otus.igorr.books.lesson23.dto.GenreDto;
import ru.otus.igorr.books.lesson23.execptions.DeleteReferenceRecordException;
import ru.otus.igorr.books.lesson23.repository.author.AuthorRepository;
import ru.otus.igorr.books.lesson23.repository.book.BookRepository;
import ru.otus.igorr.books.lesson23.repository.genre.GenreRepository;

import java.util.List;
import java.util.stream.Collectors;


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
    public GenreDto get(String id) {
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
        return genreRepository.findAll()
                .stream()
                .map(genre -> converter.convert(genre))
                .collect(Collectors.toList());
    }

    @Override
    public List<GenreDto> getListByName(String mask) {
        return genreRepository.findByNameLike(mask)
                .stream()
                .map(genre -> converter.convert(genre))
                .collect(Collectors.toList());
    }

    private boolean checkForDelete(String genreId) {
        return bookRepository.findByGenreId(genreId).size() == 0
                && authorRepository.findByGenreId(genreId).size() == 0;
    }

}
