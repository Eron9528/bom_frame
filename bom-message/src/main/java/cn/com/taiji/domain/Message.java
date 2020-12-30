package cn.com.taiji.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *   消息服务，包括消息表，记录消息内容，发送人，发送时间，日志记录。
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "MESSAGE")
public class Message {
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Id
    private String id;

}
