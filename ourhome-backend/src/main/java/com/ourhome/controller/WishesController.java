package com.ourhome.controller;

import com.ourhome.dto.Wishes;
import com.ourhome.implemention.WishesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/wishes")
public class WishesController {

    @Autowired
    WishesServiceImpl wishesServiceImpl;

    @GetMapping("/{user_id}")
    public List<Wishes> searchWishesByUser(@PathVariable(name = "user_id") int user_id) {
        return wishesServiceImpl.searchWishesByUser(user_id);
    }

    @GetMapping("/{user_id}/{home_id}")
    public boolean isInWishlist(@PathVariable(name = "user_id") int user_id, @PathVariable(name = "home_id") int home_id) {
        return wishesServiceImpl.searchWishesByUserAndHome(user_id, home_id) != null;
    }

    @PostMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public void saveWish(@RequestBody Wishes wish) {
        wishesServiceImpl.saveWish(wish);
    }

    @Transactional
    @DeleteMapping("/{user_id}/{home_id}")
    public void deleteWish(@PathVariable(name = "user_id") int user_id, @PathVariable(name = "home_id") int home_id) {
        wishesServiceImpl.deleteWishByUserAndHome(user_id, home_id);
    }

}
