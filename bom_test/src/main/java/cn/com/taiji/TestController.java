package cn.com.taiji;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@CrossOrigin
public class TestController {

    @RequestMapping("login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        if(username.equals("admin") && password.equals("123456"))
            return "success";
        else
            return "error";
    }
}
