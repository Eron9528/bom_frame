package cn.com.taiji.domain;

import cn.com.taiji.domain.dict.OrderStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_SERVE_ORDER_STATE")
public class OrderState {

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Id
    private String id;
    @OneToOne
    @JoinColumn(name="orderId",referencedColumnName="id")
    private Order order;
    @Column(name = "ORDER_STATUS")
    private OrderStatus orderStatus;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
