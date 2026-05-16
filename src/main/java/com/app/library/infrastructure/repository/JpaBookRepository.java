package com.app.library.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.library.domain.models.Book;

@Repository
public interface JpaBookRepository extends JpaRepository<Book, UUID> {
}
