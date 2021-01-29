package cn.com.taiji.service.interview;

import cn.com.taiji.domain.interview.Answer;

public interface AnswerService {
    /**
     * @描述   回答问题
     * @创建人 Mayu
     * @创建时间 2021/1/29
    */
    Answer replyQuestion(long id, Answer answer);
}