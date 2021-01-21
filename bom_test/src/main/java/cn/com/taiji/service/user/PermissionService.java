package cn.com.taiji.service.user;

import cn.com.taiji.domain.user.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findAll();
}
