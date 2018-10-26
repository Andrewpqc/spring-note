package com.andrewpqc.readinglist.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findBooksByAuthor(String author);
}
