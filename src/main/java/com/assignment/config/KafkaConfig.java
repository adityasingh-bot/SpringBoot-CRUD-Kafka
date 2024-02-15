package com.assignment.config;


import org.springframework.context.annotation.Configuration;


@Configuration
public class KafkaConfig {
    public static final String ADD_BOOK_KAFKA_TOPIC = "add_book_audit";
    public static final String GET_BOOK_KAFKA_TOPIC = "get_book_audit";
    public static final String EDIT_BOOK_KAFKA_TOPIC = "edit_book_audit";
    public static final String DELETE_BOOK_KAFKA_TOPIC = "delete_book_audit";

//    public NewTopic createTopic(){
//        return TopicBuilder.name(KAFKA_TOPIC).build();
//    }
}
