package com.ecommerce.service.user.impl;

import com.ecommerce.dto.MeetingplaceDto;
import com.ecommerce.entity.Meetingplace;
import com.ecommerce.repo.MeetingplaceRepository;
import com.ecommerce.service.user.MeetingplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MeetingplaceServiceImpl implements MeetingplaceService {

    @Autowired
    private MeetingplaceRepository meetingplaceRepository;

    @Override
    public List<MeetingplaceDto> getAllMeetingplaces() {
        return meetingplaceRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MeetingplaceDto> getMeetingplaceById(Long id) {
        return meetingplaceRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public MeetingplaceDto saveMeetingplace(MeetingplaceDto meetingplaceDTO) {
        Meetingplace meetingplace = convertToEntity(meetingplaceDTO);
        Meetingplace savedMeetingplace = meetingplaceRepository.save(meetingplace);
        return convertToDTO(savedMeetingplace);
    }

    @Override
    public MeetingplaceDto updateMeetingplace(Long id, MeetingplaceDto updatedMeetingplaceDto) {
        return meetingplaceRepository.findById(id).map(existingMeetingplace -> {
            existingMeetingplace.setName(updatedMeetingplaceDto.getName());
            existingMeetingplace.setUserId(updatedMeetingplaceDto.getUserId());
            Meetingplace updatedMeetingplace = meetingplaceRepository.save(existingMeetingplace);
            return convertToDTO(updatedMeetingplace);
        }).orElseThrow(() -> new RuntimeException("Meeting place not found with id " + id));
    }


    @Override
    public void deleteMeetingplace(Long id) {
        meetingplaceRepository.deleteById(id);
    }

    private MeetingplaceDto convertToDTO(Meetingplace meetingplace) {
        return new MeetingplaceDto(meetingplace.getId(), meetingplace.getName(), meetingplace.getUserId());
    }

    private Meetingplace convertToEntity(MeetingplaceDto meetingplaceDTO) {
        Meetingplace meetingplace = new Meetingplace();
        meetingplace.setId(meetingplaceDTO.getId());
        meetingplace.setName(meetingplaceDTO.getName());
        meetingplace.setUserId(meetingplaceDTO.getUserId());
        return meetingplace;
    }
}