package com.example.bookmanager.repository;

import com.example.bookmanager.domain.BookReviewInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bangjinhyuk on 2021/07/19.
 */
public interface BookReviewInfoRepository extends JpaRepository<BookReviewInfo,Long> {
}
