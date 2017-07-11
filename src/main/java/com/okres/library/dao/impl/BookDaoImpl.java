package com.okres.library.dao.impl;

import com.okres.library.dao.interfaces.BookDao;
import com.okres.library.entities.Author;
import com.okres.library.entities.Book;
import com.okres.library.entities.Genre;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
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


//    It is for user can watch book but thithout content
    private ProjectionList bookProjection;

    public BookDaoImpl () {
        bookProjection = Projections.projectionList();
        bookProjection.add(Projections.property("id"), "id");
        bookProjection.add(Projections.property("name"), "name");
        bookProjection.add(Projections.property("image"), "image");
        bookProjection.add(Projections.property("genre"), "genre");
        bookProjection.add(Projections.property("pageCount"), "pageCount");
        bookProjection.add(Projections.property("isbn"), "isbn");
        bookProjection.add(Projections.property("publisher"), "publisher");
        bookProjection.add(Projections.property("author"), "author");
        bookProjection.add(Projections.property("publisherYear"), "publisherYear");
        bookProjection.add(Projections.property("description"), "description");
        bookProjection.add(Projections.property("rating"), "rating");
        bookProjection.add(Projections.property("voteCount"), "voteCount");
    }

    @Transactional
    public List<Book> getBooks() {
       List<Book> books = createBookList(createBookCriteria());
       return books;
    }

    @Transactional
    public List<Book> getBooks(Author author) {
        List<Book> books = createBookList(createBookCriteria().add(Restrictions.ilike("author.fio",author.getFio(), MatchMode.ANYWHERE)));
        return books;
    }

    public List<Book> getBooks(String bookName) {
        List<Book> books = createBookList(createBookCriteria().add(Restrictions.ilike("b.name",bookName, MatchMode.ANYWHERE)));
        return books;
    }

    public List<Book> getBooks(Genre genre) {
        List<Book> books = createBookList(createBookCriteria().add(Restrictions.ilike("b.genre", genre.getName(), MatchMode.ANYWHERE)));
        return books;
    }

    public List<Book> getBooks(Character letter) {
        List<Book> books = createBookList(createBookCriteria().add(Restrictions.ilike("b.name", String.valueOf(letter), MatchMode.ANYWHERE)));
        return books;
    }

//    creat aliases
    private void creatAliases (DetachedCriteria criteria) {
        criteria.createAlias("b.author", "author");
        criteria.createAlias("b.genre", "genre");
        criteria.createAlias("b.publisher", "publisher");
    }

//    that method return collection of Book in order by name and only fields wrote in Projection
    private List<Book> createBookList (DetachedCriteria bookListCriteria) {
        Criteria criteria = bookListCriteria.getExecutableCriteria(sessionFactory.getCurrentSession());
        criteria.addOrder(Order.asc("b.name")).setProjection(bookProjection).setResultTransformer(Transformers.aliasToBean(Book.class));
        return criteria.list();
    }

    public DetachedCriteria createBookCriteria() {
        DetachedCriteria bookListCreteria = DetachedCriteria.forClass(Book.class, "b");
        creatAliases(bookListCreteria);
        return bookListCreteria;
    }
}
