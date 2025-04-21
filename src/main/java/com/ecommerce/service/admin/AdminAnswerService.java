package com.ecommerce.service.admin;

import com.ecommerce.dto.AnswerDto;
import java.util.List;

public interface AdminAnswerService {
    List<AnswerDto> getAllAnswers();
    AnswerDto getAnswerById(Long id);
    AnswerDto createAnswer(AnswerDto answerDto);
    AnswerDto updateAnswer(Long id, AnswerDto updatedAnswerDto);
    void deleteAnswer(Long id);
}
