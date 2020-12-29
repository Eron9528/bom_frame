package cn.com.taiji.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @描述  此表为付款渠道表，如果从字面意思进行理解便可知道，这个是付款时的渠道。
 *          不管是商户还是用户其相关的付款渠道信息都是在此 配置，如果在这个表中将渠道置为无效，则在支付前端看不到此渠道。
 * @创建人 Mayu
 * @创建时间 2020/12/29
*/
@Data
@NoArgsConstructor
@Entity
@Table(name= "PAYMENT_CHANNEL")
public class PaymentChannel {
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Id
    private String id;
}
