package com.assignment.service;

import com.assignment.model.Book;
import com.assignment.model.BookAudit;
import com.assignment.repo.BookAuditRepo;
import com.assignment.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookrepo;
    @Autowired
    private BookAuditRepo bookAuditRepo;
    public List<Book> getAllBook(){
        return bookrepo.findAll();
    }
    public List<BookAudit> getAllAuditBook(){
        return bookAuditRepo.findAll();
    }
    public Book saveBook(Book book){
        return bookrepo.save(book);
    }
    public Book getBookById(String id){
        return bookrepo.findById(id).orElse(null);
    }

    public Book updateBookById(String id, Book updatedBook){
        if(bookrepo.existsById(id)){
            updatedBook.setId(id);
            return bookrepo.save(updatedBook);
        }
        return null;
    }
    public void deleteBook(String id){
        bookrepo.deleteById(id);
    }
    public void saveAudit(BookAudit audit){
        bookAuditRepo.save(audit);
    }


}
