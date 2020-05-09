package com.ascendmoney.td.controller;

import com.ascendmoney.td.domain.Book;
import com.ascendmoney.td.exception.BookNotFoundException;
import com.ascendmoney.td.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        log.info("Book Controller initialized");
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBookById() {
        log.info("Get all book");
        return bookService.listAllBook();
    }

    @GetMapping("/books/{author}")
    public Book findBookByAuthor(@PathVariable("author") String author) {
        return bookService.findBookByAuthor(author).orElseThrow(
                () -> new BookNotFoundException(String.format("Can not find book with author:%s", author)));

    }
}
