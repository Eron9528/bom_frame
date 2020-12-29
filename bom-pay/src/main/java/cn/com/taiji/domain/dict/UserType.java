package cn.com.taiji.domain.dict;
/**
 * @Author: Eron
 * @Description:  用户类型:  商户或者用户
 * @Date: 22:12 2020/12/29
 */
public enum UserType {
    SELLER(1),
    BUY(2);


    private final int value;

    UserType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
