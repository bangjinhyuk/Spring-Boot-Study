package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void bookTest(){
        Book book = Book.builder()
                .name("JPA 초격차 패키지")
                .authorId(1L)
                .publisherId(1L)
                .category("Spring Boot")
                .build();

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());

    }

}