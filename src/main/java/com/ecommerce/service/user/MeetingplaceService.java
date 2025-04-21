package com.ecommerce.service.user;

import com.ecommerce.dto.MeetingplaceDto;

import java.util.List;
import java.util.Optional;

public interface MeetingplaceService {
    List<MeetingplaceDto> getAllMeetingplaces();
    Optional<MeetingplaceDto> getMeetingplaceById(Long id);
    MeetingplaceDto saveMeetingplace(MeetingplaceDto meetingplaceDTO);
    MeetingplaceDto updateMeetingplace(Long id, MeetingplaceDto updatedMeetingplaceDto);
    void deleteMeetingplace(Long id);
}
