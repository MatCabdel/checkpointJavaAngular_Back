package com.checkpoint.checkpoint.wish;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishService {

    @Autowired
    private WishRepository repository;

    public List<Wish> getAll() {
        return repository.findAll();
    }

    public Wish getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->  new EntityNotFoundException("Entity with id " + id + " cannot be found"));
    }

    public Wish add(Wish wish) {
        return repository.save(wish);
    }

    public void delete(Long id) {
        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Entity with id " + id + " cannot be found");
        }
    }

    public Wish update(Wish wish, Long id) {
        Wish existingWish = getById(id);

        existingWish.setTitle(wish.getTitle());
        existingWish.setEstimatePrice(wish.getEstimatePrice());

        return repository.save(existingWish);

    }

}
