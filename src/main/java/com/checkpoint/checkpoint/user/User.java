package com.checkpoint.checkpoint.user;

import com.checkpoint.checkpoint.friend.Friend;
import com.checkpoint.checkpoint.wish.Wish;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@RequiredArgsConstructor
@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    private int age;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Wish> booking = new ArrayList<>();

    @ManyToMany(mappedBy = "users")
    @JsonIgnoreProperties("users")
    private List<Friend> friends = new ArrayList<>();
}
