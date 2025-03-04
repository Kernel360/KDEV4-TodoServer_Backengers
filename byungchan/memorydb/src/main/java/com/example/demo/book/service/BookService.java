package com.example.demo.book.service;

import com.example.demo.book.entity.BookEntity;
import com.example.demo.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    // create, update
    public BookEntity create(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    // all
    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    // delete
    public void delete(Long id) {
        bookRepository.delete(id);
    }

    // find one
    public BookEntity findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
