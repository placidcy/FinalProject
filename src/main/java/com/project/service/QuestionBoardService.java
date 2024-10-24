package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.QuestionDO;
import com.project.model.dao.QuestionDAO;

@Service
public class QuestionBoardService {
    @Autowired
    private QuestionDAO questionDAO;

    public List<QuestionDO> getQuestions(int courseId) {
        return questionDAO.getQuestions(courseId);
    }
}
