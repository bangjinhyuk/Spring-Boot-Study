package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bangjinhyuk on 2021/07/21.
 */
public interface ReviewRepository extends JpaRepository<Review,Long> {
}
