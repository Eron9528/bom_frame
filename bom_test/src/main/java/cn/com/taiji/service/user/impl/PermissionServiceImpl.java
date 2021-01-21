package cn.com.taiji.service.user.impl;

import cn.com.taiji.domain.user.Permission;
import cn.com.taiji.domain.user.PermissionRepo;
import cn.com.taiji.service.user.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepo permissionRepo;

    @Override
    public List<Permission> findAll() {
        return permissionRepo.findAll();
    }
}
