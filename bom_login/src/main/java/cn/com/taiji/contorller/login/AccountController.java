package cn.com.taiji.contorller.login;

import cn.com.taiji.dto.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
@CrossOrigin
public class AccountController {

    @GetMapping("/test")
    public Result login() {
       return new Result("data");
    }

    @PostMapping("/login")
    public Result login(@RequestParam String username,@RequestParam String password) {

        if(username.equals("admin") && password.equals("123456"))
            return new Result("success");
        else
            return new Result("error");
    }



}
