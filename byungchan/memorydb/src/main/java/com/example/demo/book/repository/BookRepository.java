package com.example.demo.book.repository;

import com.example.demo.book.entity.BookEntity;
import com.example.demo.db.SimpleDataRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository extends SimpleDataRepository<BookEntity, Long> {
}
