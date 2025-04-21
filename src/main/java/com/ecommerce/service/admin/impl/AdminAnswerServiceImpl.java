package com.ecommerce.service.admin.impl;

import com.ecommerce.dto.AnswerDto;
import com.ecommerce.entity.Answer;
import com.ecommerce.repo.AnswerRepository;
import com.ecommerce.service.admin.AdminAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminAnswerServiceImpl implements AdminAnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public List<AnswerDto> getAllAnswers() {
        // Fetch all answers and convert to DTOs
        return answerRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AnswerDto getAnswerById(Long id) {
        return answerRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public AnswerDto createAnswer(AnswerDto answerDto) {
        Answer answer = convertToEntity(answerDto);
        answer.setDatetime(LocalDateTime.now());
        return convertToDTO(answerRepository.save(answer));
    }

    @Override
    public AnswerDto updateAnswer(Long id, AnswerDto updatedAnswerDto) {
        return answerRepository.findById(id).map(answer -> {
            answer.setPost(updatedAnswerDto.getPost());
            answer.setUserid(updatedAnswerDto.getUserid());
            answer.setQid(updatedAnswerDto.getQid());
            Answer updatedAnswer = answerRepository.save(answer);
            return convertToDTO(updatedAnswer);
        }).orElseThrow(() -> new RuntimeException("Answer not found"));
    }

    @Override
    public void deleteAnswer(Long id) {
        answerRepository.deleteById(id);
    }

    // Helper methods for DTO conversion
    private AnswerDto convertToDTO(Answer answer) {
        AnswerDto dto = new AnswerDto();
        dto.setId(answer.getId());
        dto.setPost(answer.getPost());
        dto.setUserid(answer.getUserid());
        dto.setDatetime(answer.getDatetime());
        dto.setQid(answer.getQid());
        return dto;
    }

    private Answer convertToEntity(AnswerDto dto) {
        Answer answer = new Answer();
        answer.setId(dto.getId());
        answer.setPost(dto.getPost());
        answer.setUserid(dto.getUserid());
        answer.setDatetime(dto.getDatetime());
        answer.setQid(dto.getQid());
        return answer;
    }
}
