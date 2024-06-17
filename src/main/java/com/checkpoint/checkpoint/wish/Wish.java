package com.checkpoint.checkpoint.wish;

import com.checkpoint.checkpoint.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
public class Wish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String picture;
    private String description;
    private int estimatePrice;
    private String type;
    private String urlProduct;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("wish")
    @JoinColumn(name = "user_id")
    private User user;

}
