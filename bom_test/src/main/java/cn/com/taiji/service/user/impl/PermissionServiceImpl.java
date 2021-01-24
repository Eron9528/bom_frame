package cn.com.taiji.service.user.impl;

import cn.com.taiji.domain.rightsTree.Children;
import cn.com.taiji.domain.rightsTree.ConvertTree;
import cn.com.taiji.domain.rightsTree.Tree;
import cn.com.taiji.domain.rightsTree.TreeNode;
import cn.com.taiji.domain.user.Permission;
import cn.com.taiji.domain.user.PermissionRepo;
import cn.com.taiji.service.user.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepo permissionRepo;

    @Override
    public List<Permission> findAll() {
        return permissionRepo.findAll();
    }

    @Override
    public Tree<Permission> findRightsTree() {
        //获取数据集合
        List<Permission> list = permissionRepo.findAll();
        //创建工具类
        ConvertTree<Permission> convertTree = new ConvertTree<>();
        //生成森林
        Tree<Permission> forest = convertTree.getForest(list);
        return forest;
    }

    @Override
    public List<Children> findTree() {
        //获取数据集合
        List<Permission> list = permissionRepo.findAll();
        //创建工具类
        ConvertTree<Permission> convertTree = new ConvertTree<>();
        //生成森林
        Tree<Permission>  forest = convertTree.getForest(list);
        //得到树级结构
        List<TreeNode<Permission>> rightsList = forest.getTreeRoot();

        // 返回需要的数据结构。
        List<Children> tree = new ArrayList<>();
        // 遍历rightsList 为tree 赋值
        for (TreeNode<Permission> permissionTreeNode : rightsList) {
            Children children = new Children();
            children.setMenuId(permissionTreeNode.getData().getId() + "");
            children.setLayer(permissionTreeNode.getData().getLayer());
            children.setLable(permissionTreeNode.getData().getPermissionName());
            List<Children> treeChildren = new ArrayList<>();
            if(permissionTreeNode.getData().isHasChild()){
                for (TreeNode<Permission> treeNode : permissionTreeNode.getChildrenNode()){
                    Children children1 = new Children();
                    children1.setMenuId(treeNode.getData().getId() + "");
                    children1.setLayer(treeNode.getData().getLayer());
                    children1.setLable(treeNode.getData().getPermissionName());
                    treeChildren.add(children1);
                }
                children.setChildren(treeChildren);
            }
            tree.add(children);
        }
        return tree;
    }

    @Override
    public List<Permission> findChildrenByMenuId(long menuId) {
        List<Permission> rights = permissionRepo.findChildByMenuId(menuId);
        return rights;
    }

    @Override
    public List<Permission> findFirstLayer() {
        return permissionRepo.findFirstLayer();
    }

    @Override
    public Permission addNode(long menuId, Permission permission) {
        if (menuId == 0){
            permission.setUpId(0);
            permission.setLayer(1);
        }else{
            Permission upRight = permissionRepo.findById(menuId).orElse(null);
            permission.setLayer(upRight.getLayer()+1);
            permission.setUpId(menuId);
            // 修改upRight 为有子孩子
            upRight.setHasChild(true);
            permissionRepo.save(upRight);
        }
        permission.setHasChild(false);
        permissionRepo.save(permission);
        return permission;
    }

}
