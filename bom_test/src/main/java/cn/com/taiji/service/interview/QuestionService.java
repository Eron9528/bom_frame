package cn.com.taiji.service.interview;

import cn.com.taiji.domain.interview.Question;

import java.util.List;

public interface QuestionService {

    /**
     * @描述   添加问题
     * @创建人 Mayu
     * @创建时间 2021/1/29
    */
    Question save(Question question);

    /**
     * @描述   修改问题
     * @创建人 Mayu
     * @创建时间 2021/1/29
    */
    Question updateQuestion(long id, Question question);

    /**
     * @描述   根据Id 删除问题
     * @创建人 Mayu
     * @创建时间 2021/1/29
    */
    Question deleteById(long id);

    /**
     * @描述    返回所查找类型的问题
     * @创建人 Mayu
     * @创建时间 2021/1/29
    */
    List<Question> listByType(String type);
}
