package cn.com.taiji.service.interview.impl;

import cn.com.taiji.domain.interview.Question;
import cn.com.taiji.domain.interview.QuestionRepository;
import cn.com.taiji.domain.interview.dict.QuestionType;
import cn.com.taiji.service.interview.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question save(Question question) {
        question.setCreateTime(LocalDateTime.now());
        // 存储用户 ID
       // question.setUserId();
        questionRepository.save(question);
        return question;
    }

    @Override
    public Question updateQuestion(long id, Question question) {
        Question question1 = questionRepository.findById(id).orElse(null);
        question1.setQuestionName(question.getQuestionName());
        question1.setQuestionContent(question.getQuestionContent());
        questionRepository.save(question1);
        return question1;
    }

    @Override
    public Question deleteById(long id) {
        Question question = questionRepository.findById(id).orElse(null);
        questionRepository.delete(question);
        return question;
    }

    @Override
    public List<Question> listByType(String type) {
        QuestionType questionType = QuestionType.JAVA;
        if (type.equals(QuestionType.SPRING.getName())){
            questionType = QuestionType.SPRING;
        }else if (type.equals(QuestionType.SPRING_BOOT.getName())) {
            questionType = QuestionType.SPRING_BOOT;
        }else if (type.equals(QuestionType.SPRING_CLOUD.getName())) {
            questionType = QuestionType.SPRING_CLOUD;
        }else if (type.equals(QuestionType.MYSQL.getName())) {
            questionType = QuestionType.MYSQL;
        }
        System.out.println(questionType.toString());
        List<Question> questionList = questionRepository.findByType(1);
        System.out.println(questionList.size());

        return questionList;
    }
}
