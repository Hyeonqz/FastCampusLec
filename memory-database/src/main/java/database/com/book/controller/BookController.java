package database.com.book.controller;

import database.com.book.entity.BookEntity;
import database.com.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/book")
@RequiredArgsConstructor
@RestController
public class BookController {
    private final BookService bookService;

    @GetMapping()
    public List<BookEntity> findAll() {
        return bookService.findAll();
    }

    @PostMapping
    public BookEntity create (@RequestBody BookEntity book) {
       return bookService.create(book);
    }

}
