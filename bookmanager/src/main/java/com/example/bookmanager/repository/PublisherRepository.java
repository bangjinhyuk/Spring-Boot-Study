package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bangjinhyuk on 2021/07/21.
 */
public interface PublisherRepository extends JpaRepository<Publisher,Long> {
}
