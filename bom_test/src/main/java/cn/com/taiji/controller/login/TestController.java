package cn.com.taiji.controller.login;

import cn.com.taiji.domain.user.User;
import cn.com.taiji.dto.Result;
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
    private UserService userService;

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
        // 用户管理
        List<String[]> listUsers = new ArrayList<>();
        listUsers.add(new String[]{"user", "用户列表"});
        //权限管理
        List<String[]> listRights = new ArrayList<>();
        listRights.add(new String[]{"roles", "角色列表"});
        listRights.add(new String[]{"rights", "权限列表"});
        // 商品管理
        List<String[]> listGoods = new ArrayList<>();
        listGoods.add(new String[]{"goods", "商品列表"});
        listGoods.add(new String[]{"addgoods","添加商品"});
        // 订单管理
        List<String[]> listOrder = new ArrayList<>();
        listOrder.add(new String[]{"order","订单列表"});
        listOrder.add(new String[]{"addorder","添加订单"});

        menus.put("用户管理", listUsers);
        menus.put("权限管理", listRights);
        menus.put("商品管理", listGoods);
        menus.put("订单管理",listOrder);
        return new Result(menus);
    }

    @RequestMapping("users")
    public Result getUser(String query , int pagenum, int pagesize){
        List<User> users = userService.listUser();
        return new Result(users);
    }

//    @PutMapping("users/{id}/")
//    public Result setState(@PathVariable(value = "id")long id) {
//        Account user = userService.changeStateById(id);
//        return new Result(user);
//    }

    @PutMapping("users/{id}/{state}")
    public Result setUserState(@PathVariable(value = "id")long id, @PathVariable("state") boolean state) {
        User user = userService.changeStateById(id,state);
        return new Result(user);
    }

    @PostMapping("adduser")
    public Result addUser(@RequestBody User account) {
        User user = userService.addUser(account);
        return new Result(user);
    }

    @GetMapping("getUser/{id}")
    public Result getUser(@PathVariable("id") long id){
        User user = userService.getUserById(id);
        return new Result(user);

    }


    @PutMapping("updateUser/{id}")
    public Result updateUser(@RequestBody User account, @PathVariable("id") long id){
        User user = userService.updateUserById(account, id);
        return new Result(user);

    }

    @DeleteMapping("deleteUser/{id}")
    public Result updateUser(@PathVariable("id") long id){
        User user = userService.deleteById(id);
        return new Result(user);
    }
}
