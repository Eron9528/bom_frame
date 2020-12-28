package cn.com.taiji.domain.dict;

public enum DeliveryWay {
    SHENTONG(1),
    YUNDA(2),
    SHUNFENG(3);

    private final int value;

    DeliveryWay(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
