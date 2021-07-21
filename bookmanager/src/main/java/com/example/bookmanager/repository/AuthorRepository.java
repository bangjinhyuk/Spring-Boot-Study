package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;

/**
 * Created by bangjinhyuk on 2021/07/21.
 */
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
