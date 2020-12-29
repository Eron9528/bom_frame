package cn.com.taiji.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**       该表为收款表。这里的收款也是对商户而言，对用户而言则是付款。比如用户在进行购物的时候，
 *          用户是付款，商户是收款，那么此时 就会向此表中插入数据，其表中也存有state字段用来表示用户付款有没有成功。
 *          只要是涉及用户的资金进入第三方系统，此表都会有收款数据写入。
 * @描述
 * @创建人 Mayu
 * @创建时间 2020/12/29
*/
@Data
@NoArgsConstructor
@Entity
@Table(name= "RECEIVABLES")
public class Receivables {
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Id
    private String id;
}
