package cn.com.taiji.domain.interview;

import cn.com.taiji.domain.interview.dict.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(nativeQuery = true, value = "select * from Question where question_type =?1")
    List<Question> findByType(int questionType);
}
