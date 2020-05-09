package com.ascendmoney.td.service;

import com.ascendmoney.td.domain.Book;
import com.ascendmoney.td.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Book> listAllBook(){
        return StreamSupport.stream(bookRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }
    public Optional<Book> findBookByAuthor(String author){
        return bookRepository.findBookByAuthor(author);
    }

    public Optional<Book> findBookById(int id){
        return bookRepository.findById(id);
    }
    public void saveBook(Book book){

        log.info("Save....");
    }
}
