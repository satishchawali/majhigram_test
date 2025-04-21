package com.ecommerce.service.admin;

import com.ecommerce.dto.FeedsDto;

import java.util.List;

public interface AdminFeedsService {
    List<FeedsDto> getAllFeeds();
    FeedsDto getFeedById(Long id);
    FeedsDto createFeed(FeedsDto feedDto);
    FeedsDto updateFeed(Long id, FeedsDto updatedFeedDto);
    void deleteFeed(Long id);
}