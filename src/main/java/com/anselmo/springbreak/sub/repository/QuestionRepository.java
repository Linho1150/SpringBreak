package com.anselmo.springbreak.sub.repository;

import com.anselmo.springbreak.sub.entity.SubQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<SubQuestionEntity,Integer> {
    SubQuestionEntity findBySubject(String subject);
    SubQuestionEntity findBySubjectAndContent(String subject, String content);
    List<SubQuestionEntity> findBySubjectLike(String subject);
}
