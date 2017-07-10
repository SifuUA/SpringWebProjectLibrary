package com.okres.library.dao.interfaces;

import com.okres.library.entities.Author;
import com.okres.library.entities.Book;
import com.okres.library.entities.Genre;

import java.util.List;

/**
 * Created by Alex on 10.07.2017.
 */
public interface BookDao {

    List<Book> getBooks();
    List<Book> getBooks(Author author);
    List<Book> getBooks(String bookName);
    List<Book> getBooks(Genre genre);
    List<Book> getBooks(Character letter);

}
