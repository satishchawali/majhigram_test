package com.ecommerce.service.user.impl;

import com.ecommerce.dto.QuestionDto;
import com.ecommerce.entity.Question;
import com.ecommerce.repo.QuestionRepository;
import com.ecommerce.service.user.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<QuestionDto> getAllQuestions() {
        return questionRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<QuestionDto> getQuestionById(Long id) {
        return questionRepository.findById(id).map(this::convertToDto);
    }

    @Override
    public QuestionDto saveQuestion(QuestionDto questionDto) {
        Question question = convertToEntity(questionDto);
        Question savedQuestion = questionRepository.save(question);
        return convertToDto(savedQuestion);
    }

    @Override
    public QuestionDto updateQuestion(Long id, QuestionDto updatedQuestionDto) {
        return questionRepository.findById(id).map(existingQuestion -> {
            existingQuestion.setPost(updatedQuestionDto.getPost());
            existingQuestion.setDatetime(updatedQuestionDto.getDatetime());
            existingQuestion.setUserId(updatedQuestionDto.getUserId());
            existingQuestion.setTag(updatedQuestionDto.getTag());
            Question updatedQuestion = questionRepository.save(existingQuestion);
            return convertToDto(updatedQuestion);
        }).orElseThrow(() -> new RuntimeException("Question not found with id " + id));
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    private QuestionDto convertToDto(Question question) {
        return new QuestionDto(
                question.getId(),
                question.getPost(),
                question.getDatetime(),
                question.getUserId(),
                question.getTag()
        );
    }

    private Question convertToEntity(QuestionDto questionDto) {
        Question question = new Question();
        question.setId(questionDto.getId());
        question.setPost(questionDto.getPost());
        question.setDatetime(questionDto.getDatetime());
        question.setUserId(questionDto.getUserId());
        question.setTag(questionDto.getTag());
        return question;
    }
}
