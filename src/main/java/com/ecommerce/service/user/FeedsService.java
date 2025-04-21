package com.ecommerce.service.user;

import com.ecommerce.dto.FeedsDto;

import java.util.List;

public interface FeedsService {
    List<FeedsDto> getAllFeeds();
    FeedsDto getFeedById(Long id);
    FeedsDto createFeed(FeedsDto feedDto);
    FeedsDto updateFeed(Long id, FeedsDto updatedFeedDto);
    void deleteFeed(Long id);
}