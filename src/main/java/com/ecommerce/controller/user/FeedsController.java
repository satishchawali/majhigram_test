package com.ecommerce.controller.user;

import com.ecommerce.dto.FeedsDto;
import com.ecommerce.service.user.FeedsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/feeds")
public class FeedsController {

    @Autowired
    private FeedsService feedsService;

    // Get all Feeds records
    @GetMapping
    public List<FeedsDto> getAllFeeds() {
        return feedsService.getAllFeeds();
    }

    // Get Feed by ID
    @GetMapping("/{id}")
    public ResponseEntity<FeedsDto> getFeedById(@PathVariable Long id) {
        FeedsDto feedDTO = feedsService.getFeedById(id);
        return ResponseEntity.ok(feedDTO);
    }

    // Create a new Feed
    @PostMapping
    public FeedsDto createFeed(@RequestBody FeedsDto feedsDTO) {
        return feedsService.createFeed(feedsDTO);
    }

    // Update an existing Feed
    @PutMapping("/{id}")
    public ResponseEntity<FeedsDto> updateFeed(@PathVariable Long id, @RequestBody FeedsDto updatedFeedDTO) {
        FeedsDto updatedFeed = feedsService.updateFeed(id, updatedFeedDTO);
        return ResponseEntity.ok(updatedFeed);
    }

    // Delete a Feed by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeed(@PathVariable Long id) {
        feedsService.deleteFeed(id);
        return ResponseEntity.noContent().build();
    }
}
