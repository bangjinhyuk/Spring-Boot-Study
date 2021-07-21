package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Author;
import com.example.bookmanager.domain.Book;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by bangjinhyuk on 2021/07/21.
 */
@SpringBootTest
class AuthorRepositoryTest {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;


    @Test
    @Transactional
    void manyToManyTest(){
        Book book1 = givenBook("책1");
        Book book2 = givenBook("책2");
        Book book3 = givenBook("개발책1");
        Book book4 = givenBook("개발책2");

        Author author1 = givenAuthor("저자1");
        Author author2 = givenAuthor("저자2");


        System.out.println(author1);

        book1.setAuthors(Lists.newArrayList(author1));
        book2.setAuthors(Lists.newArrayList(author2));
        book3.setAuthors(Lists.newArrayList(author1,author2));
        book4.setAuthors(Lists.newArrayList(author1,author2));

        author1.setBooks(Lists.newArrayList(book1,book3,book4));
        author2.setBooks(Lists.newArrayList(book2,book3,book4));
//
//        author1.addBook(book1,book3,book4);
//        author2.addBook(book2,book3,book4);

//        book1.addAuthor(author1);
//        book2.addAuthor(author2);
//        book3.addAuthor(author1,author2);
//        book4.addAuthor(author1,author2);
//
//        author1.addBook(book1,book3,book4);
//        author2.addBook(book2,book3,book4);



        bookRepository.saveAll(Lists.newArrayList(book1,book2,book3,book4));
        authorRepository.saveAll(Lists.newArrayList(author1,author2));

        System.out.println(bookRepository.findAll().get(1).getAuthors());
        System.out.println(authorRepository.findAll().get(1).getBooks());

    }

    private Book givenBook(String name){
        Book book = Book.builder().name(name).build();
        return bookRepository.save(book);
    }

    private Author givenAuthor(String name){
        Author author = Author.builder().name(name).build();
        return authorRepository.save(author);
    }


}