package cn.com.taiji.domain;

import cn.com.taiji.domain.dict.DeliveryWay;
import cn.com.taiji.domain.dict.PayWay;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDER_SERVE_ORDER")
public class Order {

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Id
    private String id;
    @Column(name = "ORDER_NUMBER")
    private String orderNumber;
    @Column(name = "GOODS_NAME")
    private String goodsName;
    @Column(name = "AMOUNT")
    private int amount;
    @Column(name = "PRICE")
    private BigDecimal price;
    @Column(name = "DELIVERY_WAY")
    @Enumerated
    private DeliveryWay deliveryWay;
    @Column(name = "PAY_WAY")
    @Enumerated
    private PayWay payWay;
    @Column(name = "SEND_GOODS_TIME")
    private LocalDateTime sendGoodsTime;
    @Column(name = "ORDER_DESC")
    private String orderDesc;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public DeliveryWay getDeliveryWay() {
        return deliveryWay;
    }

    public void setDeliveryWay(DeliveryWay deliveryWay) {
        this.deliveryWay = deliveryWay;
    }

    public PayWay getPayWay() {
        return payWay;
    }

    public void setPayWay(PayWay payWay) {
        this.payWay = payWay;
    }

    public LocalDateTime getSendGoodsTime() {
        return sendGoodsTime;
    }

    public void setSendGoodsTime(LocalDateTime sendGoodsTime) {
        this.sendGoodsTime = sendGoodsTime;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }
}
