package cn.com.taiji.controller.user;

import cn.com.taiji.domain.user.Role;
import cn.com.taiji.dto.Result;
import cn.com.taiji.dto.User.RoleDto;
import cn.com.taiji.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("roles")
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("roles")
    public Result getRoles(){
        List<RoleDto> roles = roleService.findAll();
        return new Result(roles);
    }

    @PostMapping("addRole")
    public Result getRoles(@RequestBody Role role){
        Role newRole = roleService.addRole(role);
        return new Result(newRole);
    }

    @GetMapping("findRole/{id}")
    public Result getRoles(@PathVariable("id") long id){
        Role newRole = roleService.findById(id);
        return new Result(newRole);
    }

    @PostMapping("updateRole/{id}")
    public Result getRoles(@PathVariable("id") long id,@RequestBody Role role){
        Role newRole = roleService.updateRoleById(id, role);
        return new Result(newRole);
    }

    @DeleteMapping("deleteRole/{id}")
    public Result deleteRole(@PathVariable("id") long id){
        Role newRole = roleService.deleteRoleById(id);
        return new Result(newRole);
    }
}
