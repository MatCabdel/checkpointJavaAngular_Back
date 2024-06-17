package com.checkpoint.checkpoint.wish;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/wish")
public class WishController {

    @Autowired
    private WishService service;

    @GetMapping("/get/all")
    public ResponseEntity<List<Wish>> getAll() {
        List<Wish> wishes = service.getAll();
        return new ResponseEntity<>(wishes, HttpStatus.OK); // 200
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Wish> getById(@PathVariable Long id) {
        Wish wish = service.getById(id);
        return new ResponseEntity<>(wish, HttpStatus.OK); // 200
    }

    @PostMapping("/add")
    public ResponseEntity<Wish> add(@RequestBody Wish wish) {
        Wish newWish = service.add(wish);
        return new ResponseEntity<>(newWish, HttpStatus.CREATED); // 201
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Wish> update(@RequestBody Wish wish, @PathVariable Long id) {
        Wish updatedWish = service.update(wish, id);
        return new ResponseEntity<>(updatedWish, HttpStatus.OK); // 200

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
