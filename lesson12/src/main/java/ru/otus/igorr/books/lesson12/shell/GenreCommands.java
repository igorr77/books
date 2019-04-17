package ru.otus.igorr.books.lesson12.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.igorr.books.lesson12.dto.GenreDto;
import ru.otus.igorr.books.lesson12.service.genre.GenreService;


import java.util.List;

@ShellComponent
public class GenreCommands {


    private final GenreService service;

    @Autowired
    public GenreCommands(GenreService service) {
        this.service = service;
    }

    /* Genre */
    @ShellMethod(key = "genreAdd", value = "Add genre entity")
    public void genreInsert(@ShellOption("--name") String name, @ShellOption("--desc") String description) {
        GenreDto dto = new GenreDto();
        dto.setName(name);
        dto.setDescription(description);
        service.add(dto);
    }


    @ShellMethod(key = "genreList", value = "Show genre list")
    public void genreList() {

        List<GenreDto> list = service.getList();

        int breakPoint = 0;

        list.forEach(System.out::println);
    }


    /*
    @ShellMethod(key = "genreGet", value = "Show Genre object")
    public void genreGet(@ShellOption("id") int id) {
        Genre genre = service.get(id);
        System.out.println(genre.toString());
    }

    @ShellMethod(key = "genreDel", value = "Delete Genre object by id")
    public void genreDelete(@ShellOption("id") int id) {
        Genre genre = new Genre();
        genre.setId(id);
        int rowCount = service.delete(genre);
        System.out.println("Deleted rows:" + rowCount);
    }

    @ShellMethod(key = "genreList", value = "Show genre list")
    public void genreList() {
        List<Genre> genreList = service.getList("");
        genreList.forEach(System.out::println);
    }
    */


}
