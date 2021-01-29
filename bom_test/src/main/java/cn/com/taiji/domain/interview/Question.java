package cn.com.taiji.domain.interview;

import cn.com.taiji.domain.interview.dict.QuestionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "QUESTION")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "QUESTION_NAME")
    private String questionName;          // 问题名称
    @Column(name = "QUESTION_CONTENT")
    private String questionContent;       // 问题内容
    @Column(name = "QUESTION_TYPE")
    @Enumerated
    private QuestionType type;            // 问题类型
    @Column(name = "CREATE_TIME")
    private LocalDateTime createTime;     // 创建时间
    @Column(name = "USERID")
    private String userId;                // 创建人ID
}
