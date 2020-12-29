package cn.com.taiji.service;

import cn.com.taiji.domain.Order;

import java.util.List;

public interface OrderService {

    /**
     * @描述   添加订单
     * @创建人 Mayu
     * @创建时间 2020/12/29
    */
    void addOrder(String id);
    /**
     * @描述  删除订单
     * @创建人 Mayu
     * @创建时间 2020/12/29
    */
    void deleteOrder(String id);
    /**
     * @描述  删除所有订单
     * @创建人 Mayu
     * @创建时间 2020/12/29
    */
    void deleteAllOrder(List<String> ids);
    /**
     * @描述  更新订单
     * @创建人 Mayu
     * @创建时间 2020/12/29
    */
    void update(Order order);
    /**
     * @描述  查询订单
     * @创建人 Mayu
     * @创建时间 2020/12/29
    */
    Order select(String id);

}
