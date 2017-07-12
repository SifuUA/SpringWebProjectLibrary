package com.okres.library.objects;

import com.okres.library.dao.interfaces.BookDAO;
import com.okres.library.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Alex on 12.07.2017.
 */
@Component
public class LibraryFacade {

    private BookDAO bookDAO;

    private List<Book> books;

    @Autowired

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
        books = bookDAO.getBooks();
    }

    public List<Book> getBooks() {
        return books;
    }
}
