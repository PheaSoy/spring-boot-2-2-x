package com.ascendmoney.td;

import com.ascendmoney.td.domain.Book;
import com.ascendmoney.td.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

@org.springframework.boot.autoconfigure.SpringBootApplication
@Slf4j
@EnableAsync
public class SpringBootApplication implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }

    List<Book> books = Arrays.asList(
            new Book("Cloud-Native Java", "Josh Long", "1000-01"),
            new Book("Enterprise Kubernetes", "Michael Elder, Jake Kitchener" ,"1000-02")
    );

    @Override
    public void run(String... args) throws Exception {

        bookRepository.saveAll(books);
        bookRepository.findAll().forEach(System.out::print);
        bookRepository.findBookBySnb("1000-01").thenAcceptAsync(bk -> log.info("bk:{}",bk));
        bookRepository.findBookBySnb("1000-02").thenAcceptAsync(bk -> log.info("bk:{}",bk));
    }

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor
                executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("BookLookUp-");
        executor.initialize();
        return executor;
    }
}
