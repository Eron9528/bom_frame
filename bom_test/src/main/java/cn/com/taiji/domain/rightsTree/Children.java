package cn.com.taiji.domain.rightsTree;

import java.util.List;

public class Children{
    private String menuId;   //id
    private int layer;    // 层级
    private String lable;   // 树名称
    private List<Children> children;   // 树孩子

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }
}
