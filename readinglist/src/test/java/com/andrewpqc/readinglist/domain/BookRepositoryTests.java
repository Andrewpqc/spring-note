package com.andrewpqc.readinglist.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class BookRepositoryTests {
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void CreateBook() {
        Book b = new Book();
        b.setAuthor("Andrewpqc");
        b.setTitle("Thinking in Java");
        b.setDescription("description of thinking in java");
        bookRepository.save(b);
        b.setTitle("another book");
        bookRepository.save(b);
    }


    @Test
    public void UpdateBook() {
        Book book = bookRepository.findBookById(1L);//null
        book.setTitle("Thinking in java 2");
        bookRepository.save(book);
    }


    @Test
    public void GetBook() {
        for (Book book : bookRepository.findAll())
            System.out.println(book);
    }

    @Test
    public void DeleteBook() {
        bookRepository.deleteById(1L);
    }


}
