package com.chq.project.cloud.common.entity.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述：角色管理实体类
 *
 * @author CHQ
 * @date 2020-05-14
 */
@ApiModel("角色管理实体类")
@Data
public class RoleModel {

    @ApiModelProperty(value = "主键")
    private Integer id;
    @ApiModelProperty(value = "角色名称")
    private String roleName;
    @ApiModelProperty(value = "否是可用 1: 可用0:不可用")
    private Integer usable;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "是否删除0:否1:是")
    private Integer isDelete;
    @ApiModelProperty(value = "权限ID,多个用逗号隔开")
    private String menuIds;
}
