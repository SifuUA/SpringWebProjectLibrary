package com.okres.library.dao.impl;

import com.okres.library.dao.interfaces.BookDao;
import com.okres.library.entities.Author;
import com.okres.library.entities.Book;
import com.okres.library.entities.Genre;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Alex on 10.07.2017.
 */
@Component
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    private List<Book> books;

    @Transactional
    public List<Book> getBooks() {
        books = (List<Book>) sessionFactory.getCurrentSession()
                .createCriteria(Book.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return books;
    }

    public List<Book> getBooks(Author author) {
        return null;
    }

    public List<Book> getBooks(String bookName) {
        return null;
    }

    public List<Book> getBooks(Genre genre) {
        return null;
    }

    public List<Book> getBooks(Character letter) {
        return null;
    }
}
