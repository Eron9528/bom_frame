package cn.com.taiji.controller.login;

import cn.com.taiji.domain.user.Permission;
import cn.com.taiji.domain.user.User;
import cn.com.taiji.dto.Result;
import cn.com.taiji.service.user.PermissionService;
import cn.com.taiji.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
@CrossOrigin
public class TestController {

    @Autowired
    PermissionService permissionService;

    @RequestMapping("login")
    public Map<String,String> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        Map<String, String> result = new HashMap<>();
        if(username.equals("admin" ) && password.equals("123456")) {
            result.put("data", "success");
            result.put("token", "kadslkadflakdsjf;alkdfja;ldkfja;ldkfja;oiwehjf;okncd");
        }else {
            result.put("data", "error");
        }
        return result;
    }

    @RequestMapping("getMenu")
    public Result getMenu(){
        Map<String, List<String[]>> menus = new HashMap<>();
        // 先找到第一层菜单
        List<Permission> firstLayer = permissionService.findFirstLayer();
        firstLayer.forEach(first -> {
            List<Permission> secondLayer = new ArrayList<>();
            secondLayer = permissionService.findChildrenByMenuId(first.getId());
            // 建立二级菜单容器
            List<String[]> secondList = new ArrayList<>();
            secondLayer.forEach(second -> {

                // 还有第三层的数据
//                List<String[]> listfirst = new ArrayList<>();
//                List<Permission> thirdLayer = new ArrayList<>();
//                thirdLayer = permissionService.findChildrenByMenuId(first.getId());
//                thirdLayer.forEach(third -> {
//
//                });
                secondList.add(new String[]{second.getMenu(),second.getPermissionName()});
            });
            menus.put(first.getPermissionName(),secondList);
        });


        // 用户管理
//        List<String[]> listUsers = new ArrayList<>();
//        listUsers.add(new String[]{"user", "用户列表"});
//        //权限管理
//        List<String[]> listRights = new ArrayList<>();
//        listRights.add(new String[]{"roles", "角色列表"});
//        listRights.add(new String[]{"rights", "权限列表"});
//        // 商品管理
//        List<String[]> listGoods = new ArrayList<>();
//        listGoods.add(new String[]{"goods", "商品列表"});
//        listGoods.add(new String[]{"addgoods","添加商品"});
//        // 订单管理
//        List<String[]> listOrder = new ArrayList<>();
//        listOrder.add(new String[]{"order","订单列表"});
//        listOrder.add(new String[]{"addorder","添加订单"});
//
//        menus.put("用户管理", listUsers);
//        menus.put("权限管理", listRights);
//        menus.put("商品管理", listGoods);
//        menus.put("订单管理",listOrder);
        return new Result(menus);
    }


}
