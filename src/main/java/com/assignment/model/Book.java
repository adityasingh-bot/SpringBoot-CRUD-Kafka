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
@Document(collection = "books")
public class Book {
    public Book() {
    }

    public Book(String id, String title, String author, String image) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.image = image;
    }

    @Id
    private String id;
    private String title;
    private  String author;
    private String image;
}
