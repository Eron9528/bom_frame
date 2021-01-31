package cn.com.taiji.service.interview.impl;

import cn.com.taiji.domain.interview.Answer;
import cn.com.taiji.domain.interview.AnswerRepository;
import cn.com.taiji.service.interview.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Answer replyQuestion(long id, Answer answer) {
        answer.setCreateTime(LocalDateTime.now());
        answer.setUserId(id);
        answerRepository.save(answer);
        return answer;
    }

    @Override
    public Answer editReply(long id, Answer answer) {
        Answer answer1 = answerRepository.findById(id).orElse(null);
        answer1.setAnswerContent(answer.getAnswerContent());
        answerRepository.save(answer1);
        return answer1;
    }

    @Override
    public Answer deleteById(long id) {
        Answer answer = answerRepository.findById(id).orElse(null);
        answerRepository.delete(answer);
        return answer;
    }
}
