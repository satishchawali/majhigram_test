package com.ecommerce.service.admin.impl;

import com.ecommerce.dto.FeedsDto;
import com.ecommerce.entity.Feeds;
import com.ecommerce.repo.FeedsRepository;
import com.ecommerce.service.admin.AdminFeedsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminFeedsServiceImpl implements AdminFeedsService {

    @Autowired
    private FeedsRepository repository;

    @Override
    public List<FeedsDto> getAllFeeds() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FeedsDto getFeedById(Long id) {
        Feeds feed = repository.findById(id).orElse(null);
        return convertToDTO(feed);
    }

    @Override
    public FeedsDto createFeed(FeedsDto feedDTO) {
        Feeds feed = convertToEntity(feedDTO);
        Feeds savedFeed = repository.save(feed);
        return convertToDTO(savedFeed);
    }

    @Override
    public FeedsDto updateFeed(Long id, FeedsDto updatedFeedDTO) {
        return repository.findById(id).map(existingFeed -> {
            existingFeed.setTitle(updatedFeedDTO.getTitle());
            existingFeed.setText(updatedFeedDTO.getText());
            existingFeed.setType(updatedFeedDTO.getType());
            existingFeed.setDate(updatedFeedDTO.getDate());
            existingFeed.setWhatsnew(updatedFeedDTO.getWhatsnew());
            existingFeed.setAuthor(updatedFeedDTO.getAuthor());
            existingFeed.setDeleted(updatedFeedDTO.getDeleted());
            return convertToDTO(repository.save(existingFeed));
        }).orElse(null);
    }

    @Override
    public void deleteFeed(Long id) {
        repository.deleteById(id);
    }

    private FeedsDto convertToDTO(Feeds feed) {
        if (feed == null) {
            return null;
        }
        return new FeedsDto(
                feed.getId(),
                feed.getTitle(),
                feed.getText(),
                feed.getType(),
                feed.getDate(),
                feed.getWhatsnew(),
                feed.getAuthor(),
                feed.getDeleted()
        );
    }

    private Feeds convertToEntity(FeedsDto dto) {
        Feeds feed = new Feeds();
        feed.setId(dto.getId());
        feed.setTitle(dto.getTitle());
        feed.setText(dto.getText());
        feed.setType(dto.getType());
        feed.setDate(dto.getDate());
        feed.setWhatsnew(dto.getWhatsnew());
        feed.setAuthor(dto.getAuthor());
        feed.setDeleted(dto.getDeleted());
        return feed;
    }
}
