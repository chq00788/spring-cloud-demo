package com.chq.project.cloud.common.entity.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 角色权限关联实体类
 *
 * @author CHQ
 */
@Data
public class RoleMenuModel {

    private Integer id;

    private Integer roleId;

    private Integer menuId;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public RoleMenuModel() {
    }

    public RoleMenuModel(Integer roleId, Integer menuId) {
        this.roleId = roleId;
        this.menuId = menuId;
        this.createTime = new Date();
    }
}
