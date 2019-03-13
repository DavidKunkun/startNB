package com.web.start.service;


import com.web.start.model.Question;
import com.web.start.dao.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

/**
 * Created by 续泽坤
 */
@Service
public class QuestionService {
    @Autowired
    QuestionDAO questionDAO;
    @Autowired
    SensitiveService sensitiveService;



    public int addQuestion(Question question) {
        //防止HTML语句对网页的攻击
        question.setTitle(HtmlUtils.htmlEscape(question.getTitle()));
        question.setContent(HtmlUtils.htmlEscape(question.getContent()));
        // 敏感词过滤
        question.setTitle(sensitiveService.filter(question.getTitle()));
        question.setContent(sensitiveService.filter(question.getContent()));
        return questionDAO.addQuestion(question) > 0 ? question.getId() : 0;
    }
    public Question getById(int id) {
        return questionDAO.getById(id);
    }
    public List<Question> getLatestQuestions(int userId, int offset, int limit) {
        return questionDAO.selectLatestQuestions(userId,offset,limit);
    }
    public int updateCommentCount(int id, int count) {
        return questionDAO.updateCommentCount(id, count);
    }

}
