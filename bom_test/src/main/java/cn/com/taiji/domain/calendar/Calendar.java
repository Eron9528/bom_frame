package cn.com.taiji.domain.calendar;

import cn.com.taiji.domain.calendar.dict.JobType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CALENDAR")
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "DAY")
    private LocalDate day;
    @Column(name = "TYPE")
    @Enumerated
    private JobType type;     //  当天值班属性
    @Column(name = "DAY_MESSAGE")
    private String dayMessage;

}
