package com.anselmo.springbreak.sub.controller;

import com.anselmo.springbreak.sub.entity.SubQuestionEntity;
import com.anselmo.springbreak.sub.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/sub")
public class SubController {

    private final QuestionRepository questionRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String subMain(){
        return "hello sub";
    }

    @RequestMapping(value = "/question/list",method = RequestMethod.GET)
    public String questionList(Model model){
        List<SubQuestionEntity> subQuestionEntityList = this.questionRepository.findAll();
        model.addAttribute("questionList",subQuestionEntityList);
        return "question_list";
    }
}
