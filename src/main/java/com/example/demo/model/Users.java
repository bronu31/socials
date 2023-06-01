package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {
@Id
@GeneratedValue
    private Long user_id;

    private String name;

    private String email;

    private String password;


    private List<Long> friends;


    private List<Long> friend_request;


    private List<Long> subscribers;


    public Users(Long id, String name, String email, String password) {
        this.user_id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
