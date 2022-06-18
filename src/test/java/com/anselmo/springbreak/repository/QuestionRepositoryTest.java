package com.anselmo.springbreak.repository;

import com.anselmo.springbreak.sub.entity.SubQuestionEntity;
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
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void testInsertSubQusetionEntity(){
        SubQuestionEntity question1 = new SubQuestionEntity();
        question1.setSubject("sbb가 무엇인가요?");
        question1.setContent("sbb에 대해서 알고싶습니다.");
        question1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(question1);

        SubQuestionEntity question2 = new SubQuestionEntity();
        question2.setSubject("스프링부트 모델 질문입니다.");
        question2.setContent("id는 자동으로 생성되나요?");
        question2.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(question2);
    }

    @Test
    void testFindAllSubQuestionEntity(){
        List<SubQuestionEntity> questions = this.questionRepository.findAll();
        assertEquals(2,questions.size());

        SubQuestionEntity questionOne = questions.get(0);
        assertEquals("sbb가 무엇인가요?",questionOne.getSubject());
    }

    @Test
    void testFindByIdSubQuestionEntity(){
        Optional<SubQuestionEntity> OptionalQuestion=this.questionRepository.findById(1);
        if(OptionalQuestion.isPresent()){
            SubQuestionEntity question = OptionalQuestion.get();
            assertEquals("sbb가 무엇인가요?",question.getSubject());
        }
    }

    @Test
    void testFindBySubjectSubQuestionEntity(){
        SubQuestionEntity question = this.questionRepository.findBySubject("sbb가 무엇인가요?");
        assertEquals(1, question.getId());
    }

    @Test
    void testFindBySubjectAndContentSubQuestionEntity(){
        SubQuestionEntity question = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?","sbb에 대해서 알고 싶습니다.");
        assertEquals(1,question.getId());
    }

    @Test
    void testFindBySubjectLikeSubQuestionEntity(){
        List<SubQuestionEntity> questionList = this.questionRepository.findBySubjectLike("sbb%");
        SubQuestionEntity question = questionList.get(0);
        assertEquals("sbb가 무엇인가요?",question.getSubject());
    }

    @Test
    void testUpdateSubQuestionEntity(){
        Optional<SubQuestionEntity> optionalSubQuestionEntity = this.questionRepository.findById(1);
        assertTrue(optionalSubQuestionEntity.isPresent());
        SubQuestionEntity question = optionalSubQuestionEntity.get();
        question.setSubject("수정된 제목");
        this.questionRepository.save(question);
    }

    @Test
    void testDeleteSubQuestionEntity(){
        assertEquals(2,this.questionRepository.count());
        Optional<SubQuestionEntity> optionalSubQuestionEntity = this.questionRepository.findById(1);
        assertTrue(optionalSubQuestionEntity.isPresent());
        SubQuestionEntity question = optionalSubQuestionEntity.get();
        this.questionRepository.delete(question);
        assertEquals(1,this.questionRepository.count());
    }
}
