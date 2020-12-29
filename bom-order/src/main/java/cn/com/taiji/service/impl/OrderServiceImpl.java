package cn.com.taiji.service.impl;

import cn.com.taiji.domain.Order;
import cn.com.taiji.domain.OrderRepository;
import cn.com.taiji.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void addOrder(String id) {

    }

    @Override
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void deleteAllOrder(List<String> ids) {

    }

    @Override
    public void update(Order order) {

    }

    @Override
    public Order select(String id) {
        return orderRepository.findById(id).orElse(null);
    }
}
