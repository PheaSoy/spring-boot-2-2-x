package com.ascendmoney.td;

import com.ascendmoney.td.domain.Book;
import com.ascendmoney.td.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }

    List<Book> books = Arrays.asList(
            new Book("Cloud-Native Java", "Josh Long", String.valueOf(new Random().nextInt(100))),
            new Book("Enterprise Kubernetes", "Michael Elder, Jake Kitchener" ,String.valueOf(new Random().nextInt(100)))
    );

    @Override
    public void run(String... args) throws Exception {

        bookRepository.saveAll(books).forEach(System.out::println);
    }

}
