package cn.com.taiji.controller.user;

import cn.com.taiji.domain.user.User;
import cn.com.taiji.dto.Result;
import cn.com.taiji.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

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
