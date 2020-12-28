package cn.com.taiji.service;

import cn.com.taiji.domain.Order;

import java.util.List;

public interface OrderService {

    void addOrder(String id);
    void deleteOrder(String id);
    void deleteAllOrder(List<String> ids);
    void update(Order order);
    void select(String id);

}
