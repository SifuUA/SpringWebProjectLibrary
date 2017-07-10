package com.okres.library.entities;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Alex on 10.07.2017.
 */
public class Book  implements Serializable{
    private Long id;
    private Author author;
    private Genre genre;
    private Publisher publisher;
    private String name;
    private byte[] content;
    private Integer pageCount;
    private String isbn;
    private Integer publisherYear;
    private byte[] image;
    private String description;
    private Integer rating;
    private Long voteCount;

    public Book() {
    }

    public Book(Long id, Author author, Genre genre, Publisher publisher, String name, byte[] content, Integer pageCount, String isbn, Integer publisherYear, byte[] image, String description, Integer rating, Long voteCount) {
        this.id = id;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.name = name;
        this.content = content;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.publisherYear = publisherYear;
        this.image = image;
        this.description = description;
        this.rating = rating;
        this.voteCount = voteCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPublisherYear() {
        return publisherYear;
    }

    public void setPublisherYear(Integer publisherYear) {
        this.publisherYear = publisherYear;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (!author.equals(book.author)) return false;
        if (!Arrays.equals(content, book.content)) return false;
        if (!description.equals(book.description)) return false;
        if (!genre.equals(book.genre)) return false;
        if (!id.equals(book.id)) return false;
        if (!Arrays.equals(image, book.image)) return false;
        if (!isbn.equals(book.isbn)) return false;
        if (!name.equals(book.name)) return false;
        if (!pageCount.equals(book.pageCount)) return false;
        if (!publisherYear.equals(book.publisherYear)) return false;
        if (!publisher.equals(book.publisher)) return false;
        if (!rating.equals(book.rating)) return false;
        if (!voteCount.equals(book.voteCount)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + genre.hashCode();
        result = 31 * result + publisher.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + Arrays.hashCode(content);
        result = 31 * result + pageCount.hashCode();
        result = 31 * result + isbn.hashCode();
        result = 31 * result + publisherYear.hashCode();
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + description.hashCode();
        result = 31 * result + rating.hashCode();
        result = 31 * result + voteCount.hashCode();
        return result;
    }
}
