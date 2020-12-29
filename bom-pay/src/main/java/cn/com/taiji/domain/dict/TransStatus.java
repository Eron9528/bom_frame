package cn.com.taiji.domain.dict;

/**
 * @Author: Eron
 * @Description: 交易状态：  等待付款、付款完成 、付款失败、已清算
 * @Date: 22:04 2020/12/29
 */
public enum TransStatus {
    WAIT_PAYMENT(1),
    FINISH_PAYMENT(2),
    FAIL_PAYMENT(3),
    LIQUIDATED(4);

    private final int value;

    TransStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
