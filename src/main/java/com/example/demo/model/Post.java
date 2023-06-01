package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long post_id;

    private String header;

    private String body;

    //TODO картинки

    private Long creator;

    private Date date_of_creation;
}
