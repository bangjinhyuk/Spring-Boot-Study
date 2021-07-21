package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Book;
import com.example.bookmanager.domain.BookReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by bangjinhyuk on 2021/07/19.
 */
@SpringBootTest
class BookReviewInfoRepositoryTest {
    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;
    @Autowired
    private BookRepository bookRepository;

    @Test
    void crud(){
        BookReviewInfo bookReviewInfo = BookReviewInfo.builder()
//                .book()
                .averageReviewScore(4.5f)
                .reviewCount(2)
                .build();

        bookReviewInfoRepository.save(bookReviewInfo);

        System.out.println(">>>"+ bookReviewInfoRepository.findAll());


    }

    @Test
    void crud2(){

        givenBookReview();
        Book result = bookReviewInfoRepository.findById(1L)
                .orElseThrow(RuntimeException::new)
                .getBook();

        System.out.println(">>>"+ result);

        BookReviewInfo result2 = bookRepository
                .findById(1L)
                .orElseThrow(RuntimeException::new)
                .getBookReviewInfo();

        System.out.println(">>>"+ result2);

        BookReviewInfo result3 = bookRepository
                .findById(result.getId())
                .orElseThrow().getBookReviewInfo();
        System.out.println(">>>"+ result3);


    }

    private Book givenBook(){
        Book book = Book.builder()
                .name("JPA 초격차 패키지")
                .authorId(1L)
                .category("Spring Boot")
                .build();

//        System.out.println(">>>"+ bookRepository.findAll());
        return bookRepository.save(book);

    }

    private void givenBookReview(){
        BookReviewInfo bookReviewInfo = BookReviewInfo.builder()
                .book(givenBook())
                .averageReviewScore(4.5f)
                .reviewCount(2)
                .build();

        bookReviewInfoRepository.save(bookReviewInfo);

        System.out.println(">>>"+ bookReviewInfoRepository.findAll());
    }
}