package com.anselmo.springbreak.sub.service;

import com.anselmo.springbreak.sub.entity.SubQuestionEntity;
import com.anselmo.springbreak.sub.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubService {

    private final QuestionRepository questionRepository;

    public List<SubQuestionEntity> getList(){
        return this.questionRepository.findAll();
    }

}
