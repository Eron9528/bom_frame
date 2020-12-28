package cn.com.taiji.controller;

import cn.com.taiji.dto.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {


    @GetMapping("/getOrder")
    public Result getOrder(){
        return new Result();
    }
}
