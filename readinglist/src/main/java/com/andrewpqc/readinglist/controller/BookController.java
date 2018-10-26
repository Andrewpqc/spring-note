package com.andrewpqc.readinglist.controller;

import com.andrewpqc.readinglist.domain.Book;
import com.andrewpqc.readinglist.domain.BookRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1.0/book")
public class BookController {
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @RequestMapping(value = "/{author}/", method = RequestMethod.GET)
    public List<Book> getBooksByAuthor(@PathVariable("author") String author) {
        return bookRepository.findBooksByAuthor(author);
    }

    @RequestMapping(value = "/{author}/{title}/", method = RequestMethod.GET)
    public String createBookByTitle(
            @PathVariable("author") String author,
            @PathVariable("title") String title) {
        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        book.setDescription("this is the description of " + title);
        bookRepository.save(book);
        return "Ok";
    }


}
