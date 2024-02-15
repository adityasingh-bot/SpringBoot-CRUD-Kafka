package com.assignment.kafka;

import com.assignment.config.KafkaConfig;
import com.assignment.model.BookAudit;
import com.assignment.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    Logger log = LoggerFactory.getLogger(KafkaConsumer.class);
    @Autowired
    private BookService bookService;

    static  final String addBookTopic = KafkaConfig.ADD_BOOK_KAFKA_TOPIC;
    static  final String editBookTopic = KafkaConfig.EDIT_BOOK_KAFKA_TOPIC;
    static  final String getBookTopic = KafkaConfig.GET_BOOK_KAFKA_TOPIC;
    static  final String deleteBookTopic = KafkaConfig.DELETE_BOOK_KAFKA_TOPIC;
    @KafkaListener(topics= addBookTopic, groupId = "add_book_group")
    public void setAddBookTopicConsumer(BookAudit msg){
        log.info("Add Consumer Logger" + msg.toString());
        bookService.saveAudit(msg);
    }

    @KafkaListener(topics= editBookTopic, groupId = "edit_book_group")
    public void setEditBookTopicConsumer(BookAudit msg){
        log.info("Edit Consumer Logger" + msg.toString());
        bookService.saveAudit(msg);
    }

    @KafkaListener(topics= getBookTopic, groupId = "get_book_group")
    public void setGetBookTopicConsumer(BookAudit msg){
        log.info("Get Consumer Logger" + msg.toString());
        bookService.saveAudit(msg);
    }

    @KafkaListener(topics= deleteBookTopic, groupId = "delete_book_group")
    public void setDeleteBookTopicConsumer(BookAudit msg){
        log.info("Delete Consumer Logger" + msg.toString());
        bookService.saveAudit(msg);
    }
}
