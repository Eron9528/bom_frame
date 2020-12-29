package cn.com.taiji.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @描述   该表是所有网关交易都要登记的表，从支付前台传入的数据首先经过gTransLog表进行 网关登记和注册，然后再进行其他记账。
 *         在表中有内部交易单号，用于查取交易数据；有returnCode用户存放银行返回 的数据；有状态标志用于查询交易的最终状态。
 *         很多时候，支付前端的请求都是直接查取网关表来进行某些交易逻辑判断。
 * @创建人 Mayu
 * @创建时间 2020/12/29
*/
@Data
@NoArgsConstructor
@Entity
@Table(name= "TRANS_LOG")
public class TransLog {
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Id
    private String id;
}
