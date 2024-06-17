package com.checkpoint.checkpoint.friend;

import com.checkpoint.checkpoint.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    private int age;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("friends")
    private List<User> users = new ArrayList<>();


}
