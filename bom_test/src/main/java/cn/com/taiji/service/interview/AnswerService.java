package cn.com.taiji.service.interview;

import cn.com.taiji.domain.interview.Answer;
import cn.com.taiji.domain.interview.Question;

public interface AnswerService {
    /**
     * @描述   回答问题
     * @创建人 Mayu
     * @创建时间 2021/1/29
    */
    Answer replyQuestion(long id, Answer answer);

    /**
     * @Author: Eron
     * @Description:    修改回答
     * @Date: 20:20 2021/1/29
     */
    Answer editReply(long id, Answer answer);

    /**
     * @Author: Eron
     * @Description:
     * @Date: 20:22 2021/1/29
     */
    Answer deleteById(long id);
}