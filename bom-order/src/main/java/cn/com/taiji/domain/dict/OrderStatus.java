package cn.com.taiji.domain.dict;

public enum OrderStatus {
    PICK(1),       // 拣货
    SHIPMENT(2),    // 出库
    TRANSPORT(4),   // 运输
    Delivery(3);     // 配送

    private final int value;

    OrderStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
