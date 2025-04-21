package com.ecommerce.service.user.impl;

import com.ecommerce.dto.MeetingSubjectDto;
import com.ecommerce.entity.MeetingSubject;
import com.ecommerce.repo.MeetingSubjectRepository;
import com.ecommerce.service.user.MeetingSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MeetingSubjectServiceImpl implements MeetingSubjectService {

    @Autowired
    private MeetingSubjectRepository meetingSubjectRepository;

    @Override
    public List<MeetingSubjectDto> getAllMeetingSubjects() {
        return meetingSubjectRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MeetingSubjectDto> getMeetingSubjectById(Long id) {
        return meetingSubjectRepository.findById(id).map(this::convertToDto);
    }

    @Override
    public MeetingSubjectDto saveMeetingSubject(MeetingSubjectDto meetingSubjectDto) {
        MeetingSubject meetingSubject = convertToEntity(meetingSubjectDto);
        MeetingSubject savedMeetingSubject = meetingSubjectRepository.save(meetingSubject);
        return convertToDto(savedMeetingSubject);
    }

    @Override
    public MeetingSubjectDto updateMeetingSubject(Long id, MeetingSubjectDto updatedMeetingSubjectDto) {
        return meetingSubjectRepository.findById(id).map(existingSubject -> {
            existingSubject.setName(updatedMeetingSubjectDto.getName());
            existingSubject.setUserId(updatedMeetingSubjectDto.getUserId());
            MeetingSubject updatedMeetingSubject = meetingSubjectRepository.save(existingSubject);
            return convertToDto(updatedMeetingSubject);
        }).orElseThrow(() -> new RuntimeException("Meeting subject not found with id " + id));
    }

    @Override
    public void deleteMeetingSubject(Long id) {
        meetingSubjectRepository.deleteById(id);
    }

    private MeetingSubjectDto convertToDto(MeetingSubject meetingSubject) {
        return new MeetingSubjectDto(meetingSubject.getId(), meetingSubject.getName(), meetingSubject.getUserId());
    }

    private MeetingSubject convertToEntity(MeetingSubjectDto meetingSubjectDto) {
        MeetingSubject meetingSubject = new MeetingSubject();
        meetingSubject.setId(meetingSubjectDto.getId());
        meetingSubject.setName(meetingSubjectDto.getName());
        meetingSubject.setUserId(meetingSubjectDto.getUserId());
        return meetingSubject;
    }
}
