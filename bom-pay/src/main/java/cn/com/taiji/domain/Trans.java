package cn.com.taiji.domain;

import cn.com.taiji.domain.dict.TransStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @描述   该表是交易表，核心点在与交易，交易必须有买和卖，只有这样才能完成交易。此时就涉及一个易被忽视的问题，比如向用户向自己钱包充值，
 *         这个阶段只是收钱，并没有存在交易，所以在这个场景下并不会向该表中写入数据。在一般的交易中，可查看表中的状态来判断此交易的状态，
 *         是等待付款、付款完成 、付款失败、已清算。支付前端也时刻通过这个表来进行其他联接查询操作。
 * @创建人 Mayu
 * @创建时间 2020/12/29
*/
@Data
@NoArgsConstructor
@Entity
@Table(name= "TRANS")
public class Trans {
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Id
    private String id;
    @Column(name = "GOOD_ID")
    private String goodId;           // 商品
    @Column(name = "SELLER")
    private String seller;           //  卖方
    @Column(name = "BUYER")
    private String buyer;             // 买方
    @Column(name = "TRANS_STATUS")
    @Enumerated
    private TransStatus transStatus;       // 交易状态
    @Column(name = "TRANS_TIME")
    private LocalDateTime transTime;     // 交易时间

}
