package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Book;
import com.example.bookmanager.domain.Publisher;
import com.example.bookmanager.domain.Review;
import com.example.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;


    @Test
    void bookTest(){
        Book book = Book.builder()
                .name("JPA 초격차 패키지")
                .authorId(1L)
                .category("Spring Boot")
                .build();

        bookRepository.save(book);

        System.out.println(">>>");
        System.out.println(">>>"+bookRepository.findAll());
        bookRepository.findAll().forEach(it -> {System.out.println(it.getBookReviewInfo());});
    }

    @Test
    @Transactional
    void BookRelationTest(){
        givenBookAndReview();
        User user = userRepository.findByEmail("leo@slowcampus.com");
        System.out.println("Review : " + user.getReviews());
        System.out.println("Book : " + user.getReviews().get(0).getBook());
        System.out.println("Publisher" + user.getReviews().get(0).getBook().getPublisher());

    }

    private void givenBookAndReview() {
        givenReview(givenUser(),givenBook(givenPublisher()));
    }
    private User givenUser(){
        return userRepository.findByEmail("leo@slowcampus.com");
    }

    private Book givenBook(Publisher publisher){
        return bookRepository.save(Book.builder().name("책 이름").category("카테고뤼").publisher(publisher).build());
    }
    private Publisher givenPublisher(){
        return publisherRepository.save(Publisher.builder().name("출판사 이름").build());
    }
    private void givenReview(User user,Book book) {
        var review = new Review();
        review.setTitle("책 이름이름을 읽은 뒤.,..");
        review.setContent("즐거웠다");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);

        reviewRepository.save(review);
    }


}