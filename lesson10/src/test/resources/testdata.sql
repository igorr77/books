-- genre
insert into genre(id, name, description) values(1, 'genre.1','genre.1.description');
insert into genre(id, name, description) values(2, 'genre.2','genre.2.description');
insert into genre(id, name, description) values(3, 'genre.3','genre.3.description');
insert into genre(id, name, description) values(999, 'genre.999','genre.999.description');
-- author
insert into author(id, first_name, sur_name, last_name) values(1, 'Firstname1','Surname1','Lastname1');
insert into author(id, first_name, sur_name, last_name) values(2, 'Firstname2','Surname2','Lastname2');
insert into author(id, first_name, sur_name, last_name) values(3, 'Firstname3','Surname3','Lastname3');
--
insert into author_genre(author_id, genre_id) values(1,1);
insert into author_genre(author_id, genre_id) values(2,1);
insert into author_genre(author_id, genre_id) values(2,2);
insert into author_genre(author_id, genre_id) values(3,1);
insert into author_genre(author_id, genre_id) values(3,2);
insert into author_genre(author_id, genre_id) values(3,3);
-- books
insert into book(id, title, genre_id, description) values(1, 'Book.1.Title', 1, 'Book.1.Description');
insert into book_author (book_id, author_id)
values (1, 1);
insert into note (id, book_id, note) values(1, 1, 'Book.1.Note.1');
insert into note (id, book_id, note) values(2, 1, 'Book.1.Note.2');
insert into note (id, book_id, note) values(3, 1, 'Book.1.Note.3');
--
insert into book(id, title, genre_id, description) values(2, 'Book.2.Title', 2, 'Book.2.Description');
insert into book_author (book_id, author_id)
values (2, 1);
insert into book_author (book_id, author_id)
values (2, 2);
--
insert into book(id, title, genre_id, description) values(3, 'Book.3.Title', 2, 'Book.3.Description');
insert into book_author (book_id, author_id)
values (3, 1);
insert into book_author (book_id, author_id)
values (3, 2);
--
insert into book(id, title, genre_id, description) values(4, 'Book.3.Title', 3, 'Book.3.Description');
insert into book_author (book_id, author_id)
values (4, 1);
insert into book_author (book_id, author_id)
values (4, 2);
-- for delete
insert into book(id, title, genre_id, description) values(999, 'Book.3.Title', 3, 'Book.3.Description');
insert into book_author (book_id, author_id)
values (999, 1);
insert into book_author (book_id, author_id)
values (999, 2);
insert into note (id, book_id, note) values(1001, 999, 'Book.999.Note.1');
insert into note (id, book_id, note) values(1002, 999, 'Book.999.Note.2');
insert into note (id, book_id, note) values(1003, 999, 'Book.999.Note.3');
