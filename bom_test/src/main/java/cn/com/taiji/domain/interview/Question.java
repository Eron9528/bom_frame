package cn.com.taiji.domain.interview;

import cn.com.taiji.domain.interview.dict.QuestionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @Column(name = "USER_ID")
    private String userId;                // 创建人ID

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
