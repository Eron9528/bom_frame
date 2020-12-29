package cn.com.taiji.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @描述   该表为付款表，这里的付款是从商户的角度来说的，对于用户来说就是收款。初次涉及账户逻辑时很容易将这逻辑搞混，
 *        这个表使用 再向用户打钱的时候才会被用到。比如在基金赎回的场景中，就会向这个表中插入数据，通过表中的状态，
 *        就可以判断其向用户打钱有没有成功，对于没有成功、 的情形又会涉及到退票的情形，这在下一章讨论。
 * @创建人 Mayu
 * @创建时间 2020/12/29
*/
@Data
@NoArgsConstructor
@Entity
@Table(name= "PAYMENTS")
public class Payments {
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Id
    private String id;
    @Column(name = "PAYMENT_AMOUNT")
    private BigDecimal paymentAmount;        // 付款金额
    @Column(name = "USER_ID")
    private String userId;                // 付款人
    @Column(name = "PAYMENT_TIME")
    private LocalDateTime paymentTime;

}
