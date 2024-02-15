package com.assignment.kafka;

import com.assignment.config.KafkaConfig;
import com.assignment.model.BookAudit;
import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    Logger log = LoggerFactory.getLogger(KafkaProducer.class);
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    String addBookTopic = KafkaConfig.ADD_BOOK_KAFKA_TOPIC;
    String editBookTopic = KafkaConfig.EDIT_BOOK_KAFKA_TOPIC;
    String getBookTopic = KafkaConfig.GET_BOOK_KAFKA_TOPIC;
    String deleteBookTopic = KafkaConfig.DELETE_BOOK_KAFKA_TOPIC;

    public void setAddBookTopicAudit(BookAudit audit){
        log.info("Producer - "+ audit.toString());
//        log.info("Topic Name" + addBookTopic);
        kafkaTemplate.send(addBookTopic, audit);
    }
    public  void setEditBookTopic(BookAudit audit){
        kafkaTemplate.send(editBookTopic, audit);
    }
    public void setGetBookTopic(BookAudit audit){
        kafkaTemplate.send(getBookTopic, audit);
    }
    public void setDeleteBookTopic(BookAudit audit){
        kafkaTemplate.send(deleteBookTopic, audit);
    }

}
