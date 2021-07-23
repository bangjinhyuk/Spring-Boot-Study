package com.example.bookmanager.repository;

import com.example.bookmanager.domain.BookAndAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bangjinhyuk on 2021/07/23.
 */
public interface BookAndAuthorRepository extends JpaRepository<BookAndAuthor,Long> {
}
