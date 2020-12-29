package cn.com.taiji.domain.dict;
/**
 * @Author: Eron
 * @Description:
 * @Date: 23:17 2020/12/29
 */
public enum ChannelType {
    Bank(1),
    Ali(2),
    Wechat(3);


    private final int value;

    ChannelType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
