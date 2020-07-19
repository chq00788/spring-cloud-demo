package com.chq.project.cloud.common.entity.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 描述：用户管理实体类
 *
 * @author CHQ
 * @date 2020-05-12
 */
@ApiModel("用户管理实体类")
@Data
public class UserModel {

    @ApiModelProperty(value = "主键")
    private Integer id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "姓名")
    private String realName;
    @ApiModelProperty(value = "联系电话")
    private String phone;
    @ApiModelProperty(value = "头像")
    private String photo;
    @ApiModelProperty(value = "否是可用 1: 可用0:不可用")
    private Integer usable;
    @ApiModelProperty(value = "部门ID")
    private Integer deptId;
    @ApiModelProperty(value = "角色")
    private String role;
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @ApiModelProperty(value = "最后登录时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;
    @ApiModelProperty(value = "是否删除0:否1:是")
    private Integer isDelete;
    @ApiModelProperty(value = "排序字段默认为id")
    private String sortCode = "id";
    @ApiModelProperty(value = "排序规则默认为降序排列(DESC/ASC)")
    private String sortRole = "DESC";
}
