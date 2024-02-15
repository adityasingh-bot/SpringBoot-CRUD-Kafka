package com.assignment;

import com.assignment.config.KafkaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigTest {

    @Test
    public void configTest(){
        String addTopic = KafkaConfig.ADD_BOOK_KAFKA_TOPIC;
        String editTopic = KafkaConfig.EDIT_BOOK_KAFKA_TOPIC;
        String getTopic = KafkaConfig.GET_BOOK_KAFKA_TOPIC;
        String deleteTopic = KafkaConfig.DELETE_BOOK_KAFKA_TOPIC;

        assertEquals(addTopic, "add_book_audit");
        assertEquals(editTopic, "edit_book_audit");
        assertEquals(getTopic, "get_book_audit");
        assertEquals(deleteTopic, "delete_book_audit");
    }
//    @Test
//    public void objTest(){
//        KafkaConfig obj = new KafkaConfig();
//        assertNotNull(obj);
//    }

//    @Test
//    public void objApp(){
//        AssignmentApplication obj = new AssignmentApplication();
//        assertNotNull(obj);
//    }
}
