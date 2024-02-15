package com.assignment;

import com.assignment.model.Book;
import com.assignment.repo.BookRepo;
import com.assignment.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
    @Autowired
    private BookService bookService;
    @MockBean
    private BookRepo bookRepo;
    @Test
    public void addNewBook(){
        Book book = new Book();
        book.setTitle("Sample Title Test from Junit");
        book.setAuthor("Sample Author Test from Junit");
        book.setImage("Sample Image Test from Junit");
        when(bookRepo.save(book)).thenReturn(book);
        assertEquals(book, bookService.saveBook(book));
    }
    @Test
    public void fetchAllBook(){
        when(bookRepo.findAll()).thenReturn(Stream.of(new Book("ID1", "Title1", "Author1","ImageURL"), new Book("ID2","Title2", "Author2", "ImageURL2")).collect(Collectors.toList()));
        assertEquals(2, bookService.getAllBook().size());
    }
    @Test
    public void getBookById(){
        Book book = new Book("ID1", "Title1", "Author1", "ImageURL");
        when(bookRepo.findById("ID1"))
                .thenReturn(Optional.of(book));
        assertEquals(book, bookService.getBookById("ID1"));
    }
    @Test
    public void deleteBook(){
        Book book = new Book("ID1", "Title1", "Author1", "ImageURL");
        bookService.deleteBook(book.getId());
        verify(bookRepo, times(1)).deleteById(book.getId());
    }

}
