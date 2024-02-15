package com.assignment;
import com.assignment.model.Book;
import com.assignment.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookService bookService;
    @Test
    public void getAllBookTest() throws  Exception{
        List<Book> mockBook = Arrays.asList(
                new Book("1", "xyz", "abc", "pqr"),
                new Book("2", "xyz2", "abc2", "pqr2")
        );

        when(bookService.getAllBook()).thenReturn(mockBook);

        mockMvc.perform(get("/books/getAllBook"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
//    @Test
//    public void addBookTest() throws  Exception{
//       Book newBook = new Book("1", "xyz", "abc", "pqr");
//       Book savedBook= new Book("1", "xyz", "abc", "pqr");
//
//        when(bookService.saveBook(newBook)).thenReturn(savedBook);
//
//        mockMvc.perform(post("/books/addNewBook"))
//                .andExpect(status().isCreated())
//                .andExpect(content().contentType("application/json"));
//    }
//
//    private static String asJsonString(final Object obj){
//        try{
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
