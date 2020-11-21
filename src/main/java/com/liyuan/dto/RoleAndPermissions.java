package com.liyuan.dto;

import com.liyuan.model.MallPermission;
import com.liyuan.model.MallRole;

import java.util.List;

public class RoleAndPermissions {
    private MallRole role;
    private List<MallPermission> permissions;

    public MallRole getRole() {
        return role;
    }

    public void setRole(MallRole role) {
        this.role = role;
    }


    public List<MallPermission> getPermissions() {
        return permissions;
    }

    public void setPermission(List<MallPermission> permissions) {
        this.permissions = permissions;
    }
}
