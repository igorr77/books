package ru.otus.igorr.books.lesson14.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.igorr.books.lesson14.dto.GenreDto;
import ru.otus.igorr.books.lesson14.service.genre.GenreService;

import java.util.List;
import java.util.stream.Collectors;

@ShellComponent
public class GenreCommands {


    private static final String OFFSET = "----------------------------\n\n";
    private final GenreService service;

    @Autowired
    public GenreCommands(GenreService service) {
        this.service = service;
    }

    /* Genre */
    @ShellMethod(key = "genreAdd", value = "Add genre entity")
    public void genreAdd(@ShellOption("--name") String name, @ShellOption("--desc") String description) {
        GenreDto dto = new GenreDto();
        dto.setName(name);
        dto.setDescription(description);
        service.add(dto);
    }


    @ShellMethod(key = "genreList", value = "Show genre list")
    public String genreList() {

        List<GenreDto> list = service.getList();

        System.out.println();
        return OFFSET + list.stream().map(genre -> genre.toString()).collect(Collectors.joining("\n"));
    }


    @ShellMethod(key = "genreLikeName", value = "Show genre list by name like mask")
    public String genreLikeName(@ShellOption("--mask") String mask) {

        List<GenreDto> list = service.getListByName(mask);

        System.out.println();
        return OFFSET + list.stream().map(genre -> genre.toString()).collect(Collectors.joining("\n"));
    }


    /*
    @ShellMethod(key = "genreDel", value = "Delete Genre object by id")
    public void genreDelete(@ShellOption("id") int id) {
        Genre genre = new Genre();
        genre.setId(id);
        int rowCount = service.delete(genre);
        System.out.println("Deleted rows:" + rowCount);
    }
    */


}
