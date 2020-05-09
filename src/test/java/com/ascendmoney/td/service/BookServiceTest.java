package com.ascendmoney.td.service;

import com.ascendmoney.td.domain.Book;
import com.ascendmoney.td.repository.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
//@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Before
    public void setUp() {
        when(bookRepository.findById(any())).thenReturn(Optional.of(new Book(1, "title", "author", "SNB")));
        bookService = new BookService(bookRepository);
    }

    @Test
    public void testOnJunit4() {
        Optional<Book> bookOptional = bookService.findBookById(1);
        Assertions.assertThat(bookOptional.isPresent()).isEqualTo(true);
    }
}
