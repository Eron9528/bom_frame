package cn.com.taiji.controller.user;

import cn.com.taiji.domain.user.Permission;
import cn.com.taiji.dto.Result;
import cn.com.taiji.service.user.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("rights")
@CrossOrigin
public class RightsController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("rights")
    public Result getRights(){
        List<Permission> right = permissionService.findAll();
        return new Result(right);
    }
}
