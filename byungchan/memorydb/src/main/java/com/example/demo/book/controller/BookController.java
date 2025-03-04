package com.example.demo.book.controller;

import com.example.demo.book.entity.BookEntity;
import com.example.demo.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    // create, update
    @PostMapping("")
    public BookEntity create(
            @RequestBody BookEntity bookEntity
    ) {
        return bookService.create(bookEntity);
    }

    // read
    @GetMapping("/all")
    public List<BookEntity> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookEntity findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    // delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

}
