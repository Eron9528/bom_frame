package cn.com.taiji.domain.interview;

import cn.com.taiji.domain.interview.dict.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByType(QuestionType questionType);
}
