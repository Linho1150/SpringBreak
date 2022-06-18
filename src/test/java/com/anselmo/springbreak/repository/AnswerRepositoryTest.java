package com.anselmo.springbreak.repository;

import com.anselmo.springbreak.sub.entity.SubAnswerEntity;
import com.anselmo.springbreak.sub.entity.SubQuestionEntity;
import com.anselmo.springbreak.sub.repository.AnswerRepository;
import com.anselmo.springbreak.sub.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AnswerRepositoryTest {
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void testSetAnswerRepository(){
        Optional<SubQuestionEntity> optionalSubQuestionEntity = this.questionRepository.findById(2);
        assertTrue(optionalSubQuestionEntity.isPresent());
        SubQuestionEntity question = optionalSubQuestionEntity.get();

        SubAnswerEntity answer = new SubAnswerEntity();
        answer.setContext("네 자동으로 생성됩니다.");
        answer.setQuestion(question);
        answer.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(answer);
    }

    @Test
    void testGetAnswerRepository(){
        Optional<SubAnswerEntity> optionalAnswer = this.answerRepository.findById(1);
        assertTrue(optionalAnswer.isPresent());
        SubAnswerEntity answer = optionalAnswer.get();
        assertEquals(2,answer.getQuestion().getId());
    }

    @Test
    void testGetAnswersByQuestionRepository(){
        Optional<SubQuestionEntity> optionalSubQuestionEntity = this.questionRepository.findById(2);
        assertTrue(optionalSubQuestionEntity.isPresent());
        SubQuestionEntity question = optionalSubQuestionEntity.get();

        List<SubAnswerEntity> answerList = question.getAnswer();
        assertEquals(1,answerList.size());
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContext());
    }
}