package com.example.bookmanager.service;

import com.example.bookmanager.domain.Author;
import com.example.bookmanager.domain.Book;
import com.example.bookmanager.repository.AuthorRepository;
import com.example.bookmanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by bangjinhyuk on 2021/07/24.
 */
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

//    @Transactional
    public void putBookAndAuthor(){
        var book = new Book();
        book.setName("JPA 시작하기");

        bookRepository.save(book);

        var author = new Author();
        author.setName("bang");

        authorRepository.save(author);

        throw new RuntimeException("오류가나서 디비 커밋 실패");

    }
}
