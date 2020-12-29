package cn.com.taiji.controller;

import cn.com.taiji.domain.Order;
import cn.com.taiji.dto.Result;
import cn.com.taiji.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getOrder/{id}")
    public Result getOrder(@PathVariable(value = "id") String id){
        Order order = orderService.select(id);
        return new Result(order);
    }
}
