package cn.com.taiji.controller.user;

import cn.com.taiji.domain.rightsTree.Children;
import cn.com.taiji.domain.rightsTree.Tree;
import cn.com.taiji.domain.user.Permission;
import cn.com.taiji.dto.Result;
import cn.com.taiji.service.user.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rights")
@CrossOrigin
public class RightsController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("rights")
    public Result getRights(){
        List<Permission> right = permissionService.findFirstLayer();
        return new Result(right);
    }

    @GetMapping("getTree")
    public Result getTree (){
        Tree<Permission> rights = permissionService.findRightsTree();
        return new Result(rights.getTreeRoot());
    }

    @GetMapping("getRightsTree")
    public Result getRightsTree () {
        List<Children> rights = permissionService.findTree();
        return new Result(rights);
    }

    @GetMapping("getRightsByMenuId/{menuId}")
    public Result getRightsByMenuId(@PathVariable("menuId") long menuId){
        List<Permission> rights = permissionService.findChildrenByMenuId(menuId);
        return new Result(rights);
    }

    @PostMapping("addNode/{menuId}")
    public Result addNode(@PathVariable("menuId") long menuId, @RequestBody Permission permission){
        Permission right = permissionService.addNode(menuId, permission);
        return new Result(right);
    }

}
