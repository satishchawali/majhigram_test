package com.ecommerce.service.admin;

import com.ecommerce.dto.QuestionDto;

import java.util.List;
import java.util.Optional;

public interface AdminQuestionService {
    List<QuestionDto> getAllQuestions();
    Optional<QuestionDto> getQuestionById(Long id);
    QuestionDto saveQuestion(QuestionDto questionDto);
    QuestionDto updateQuestion(Long id, QuestionDto updatedQuestionDto);
    void deleteQuestion(Long id);
}
