package com.example.memorydb.book.controller;

import com.example.memorydb.book.db.entity.BookEntity;
import com.example.memorydb.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    @PostMapping("")
    public BookEntity create(
            @RequestBody BookEntity book
    ) {
        return bookService.create(book);
    }

    @GetMapping("/all")
    public List<BookEntity> findAll() {
        return bookService.findAll();
    }

}
