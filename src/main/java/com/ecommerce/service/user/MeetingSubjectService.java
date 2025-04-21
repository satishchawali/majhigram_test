package com.ecommerce.service.user;

import com.ecommerce.dto.MeetingSubjectDto;

import java.util.List;
import java.util.Optional;

public interface MeetingSubjectService {
    List<MeetingSubjectDto> getAllMeetingSubjects();
    Optional<MeetingSubjectDto> getMeetingSubjectById(Long id);
    MeetingSubjectDto saveMeetingSubject(MeetingSubjectDto meetingSubjectDto);
    MeetingSubjectDto updateMeetingSubject(Long id, MeetingSubjectDto updatedMeetingSubjectDto);
    void deleteMeetingSubject(Long id);
}
