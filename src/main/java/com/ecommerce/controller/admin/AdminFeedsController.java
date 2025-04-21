package com.ecommerce.controller.admin;

import com.ecommerce.dto.FeedsDto;
import com.ecommerce.service.admin.AdminFeedsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/feeds")
public class AdminFeedsController {

    @Autowired
    private AdminFeedsService adminFeedsService;

    // Get all Feeds records
    @GetMapping
    public List<FeedsDto> getAllFeeds() {
        return adminFeedsService.getAllFeeds();
    }

    // Get Feed by ID
    @GetMapping("/{id}")
    public ResponseEntity<FeedsDto> getFeedById(@PathVariable Long id) {
        FeedsDto feedDTO = adminFeedsService.getFeedById(id);
        return ResponseEntity.ok(feedDTO);
    }

    // Create a new Feed
    @PostMapping
    public FeedsDto createFeed(@RequestBody FeedsDto feedsDTO) {
        return adminFeedsService.createFeed(feedsDTO);
    }

    // Update an existing Feed
    @PutMapping("/{id}")
    public ResponseEntity<FeedsDto> updateFeed(@PathVariable Long id, @RequestBody FeedsDto updatedFeedDTO) {
        FeedsDto updatedFeed = adminFeedsService.updateFeed(id, updatedFeedDTO);
        return ResponseEntity.ok(updatedFeed);
    }

    // Delete a Feed by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeed(@PathVariable Long id) {
        adminFeedsService.deleteFeed(id);
        return ResponseEntity.noContent().build();
    }
}
