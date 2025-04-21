package com.ecommerce.service.user;

import com.ecommerce.dto.QuestionDto;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<QuestionDto> getAllQuestions();
    Optional<QuestionDto> getQuestionById(Long id);
    QuestionDto saveQuestion(QuestionDto questionDto);
    QuestionDto updateQuestion(Long id, QuestionDto updatedQuestionDto);
    void deleteQuestion(Long id);
}
