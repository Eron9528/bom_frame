package cn.com.taiji.domain.dict;

public enum PayWay {
    AliPay(1),
    BankCard(2),
    WeChat(3),
    Cash(4);

    private final int value;

    PayWay(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
