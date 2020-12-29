package cn.com.taiji.domain;

import cn.com.taiji.domain.dict.ChannelType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @描述   该表是渠道配置表，主要是商户使用。该表中配置了商户以及此商户所接入的渠道，比如支付宝或者某银行。
 *         可以 从现实生活中去理解此逻辑，在某商户进行购物时并不是每一个商户都对某家银行支持，说的也是这个道理。
 * @创建人 Mayu
 * @创建时间 2020/12/29
*/
@Data
@NoArgsConstructor
@Entity
@Table(name= "CHANNEL_CONFIG")
public class ChannelConfig {
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Id
    private String id;
    @Column(name = "USER_ID")
    private String userId;
    @Column(name = "CHANNEL_TYPE")
    @Enumerated
    private ChannelType channelType;  // 渠道类型

}
