package com.app.library.infrastructure;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.library.entities.*;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
}
