package com.chq.project.cloud.common.entity.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

/**
* 描述：菜单管理实体类
* @author CHQ
* @date 2020-05-14
*/
@ApiModel("菜单管理实体类")
@Data
public class MenuModel {

    @ApiModelProperty(value = "主键")
    private Integer id;
    @ApiModelProperty(value = "菜单名称")
    private String menuName;
    @ApiModelProperty(value = "父级菜单ID")
    private Integer parentId;
    @ApiModelProperty(value = "显示顺序")
    private Integer orderNum;
    @ApiModelProperty(value = "请求地址")
    private String url;
    @ApiModelProperty(value = "打开方式（menuItem页签 menuBlank新窗口）")
    private String target;
    @ApiModelProperty(value = "菜单类型（1目录 2菜单 3按钮）")
    private Integer menuType;
    @ApiModelProperty(value = "否是可用 1: 可用0:不可用")
    private Integer usable;
    @ApiModelProperty(value = "权限标识")
    private String perms;
    @ApiModelProperty(value = "图标")
    private String icon;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @ApiModelProperty(value = "是否删除0:否1:是")
    private Integer isDelete;
}