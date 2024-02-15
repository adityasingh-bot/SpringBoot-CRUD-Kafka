package com.assignment.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Data
@Document(collection = "booksAudit")
public class BookAudit {
    @Id
    private String id;

    public BookAudit() {
    }

    public BookAudit(String id, String title, String author, String operation, String timestamp) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.operation = operation;
        this.timestamp = timestamp;
    }

    public BookAudit(String id, String operation, String timestamp, String count) {
        this.id = id;
        this.operation = operation;
        this.timestamp = timestamp;
        this.count = count;
    }

    public BookAudit(String operation, String timestamp, String count) {
        this.operation = operation;
        this.timestamp = timestamp;
        this.count = count;
    }

    private String title;
    private String author;
    private String operation;
    private String timestamp;
    private String count;

}
