package cn.com.taiji.domain.interview;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ANSWER")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "ANSWER_CONTENT")
    private String answerContent;
    @Column(name = "CREATE_TIME")
    private LocalDateTime createTime;
    @Column(name = "USERID")
    private String userId;
}
