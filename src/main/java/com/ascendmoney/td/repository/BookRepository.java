package com.ascendmoney.td.repository;

import com.ascendmoney.td.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface BookRepository extends CrudRepository<Book, Integer> {

    @Async
    CompletableFuture<Book> findBookBySnb(String snb);

    Optional<Book> findBookByAuthor(String author);

}
