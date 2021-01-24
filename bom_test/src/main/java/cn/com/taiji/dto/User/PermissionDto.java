package cn.com.taiji.dto.User;

import cn.com.taiji.domain.user.Permission;

import java.util.List;

public class PermissionDto {
    private long id;
    private String permissionName;
    private String menu;
    private int layer;
    private long upId;
    private List<Permission> children;

    public PermissionDto(long id, String permissionName, String menu, int layer, long upId, List<Permission> children) {
        this.id = id;
        this.permissionName = permissionName;
        this.menu = menu;
        this.layer = layer;
        this.upId = upId;
        this.children = children;
    }
}
