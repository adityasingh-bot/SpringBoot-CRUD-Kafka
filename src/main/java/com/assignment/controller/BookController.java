package com.assignment.controller;

import com.assignment.kafka.KafkaConsumer;
import com.assignment.kafka.KafkaProducer;
import com.assignment.model.Book;
import com.assignment.model.BookAudit;
import com.assignment.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BookController {
    Logger log = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BookService bookService;
    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private KafkaConsumer kafkaConsumer;

    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
    String formattedDate = sdf.format(date);
    @PostMapping("/addNewBook")
    public Book createBook(@RequestBody Book book){
        Book audit =  bookService.saveBook(book);
        kafkaProducer.setAddBookTopicAudit(new BookAudit(audit.getId(), audit.getTitle(), audit.getAuthor(), "Add New Book", formattedDate));
        log.info("Log-Id " + audit.getId());
        return audit;
    }
    @GetMapping("/bookById/{id}")
    public Book getBook(@PathVariable String id){
        return bookService.getBookById(id);

    }
    @GetMapping("/getAllBook")
    public ResponseEntity<List<Book>> getAllBook(){
        List<Book> bookList = bookService.getAllBook();
        String size = String.valueOf(bookList.size());
        log.info("Inside Get All Book");
        if(bookList.size() > 0)
            kafkaProducer.setGetBookTopic(new BookAudit("Get All Book", formattedDate, size));
        return ResponseEntity.ok(bookList);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Book book){
       Book updated = bookService.updateBookById(id, book);
       kafkaProducer.setEditBookTopic(new BookAudit("UPDATED_ID_"+updated.getId(), updated.getTitle(), updated.getAuthor(), "Update Book", formattedDate));
       return updated !=null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("deleteBook/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable String id){
        bookService.deleteBook(id);
        kafkaProducer.setDeleteBookTopic(new BookAudit("DELETED_ID_"+id,"Deleted Book", formattedDate, "1"));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAllAuditBook")
    public ResponseEntity<List<BookAudit>> getAllAuditBook(){
        List<BookAudit> bookList = bookService.getAllAuditBook();
        return ResponseEntity.ok(bookList);
    }
}

