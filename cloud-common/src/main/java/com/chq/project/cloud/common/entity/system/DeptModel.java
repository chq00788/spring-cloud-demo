package com.chq.project.cloud.common.entity.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

/**
* 描述：部门管理实体类
* @author CHQ
* @date 2020-05-14
*/
@ApiModel("部门管理实体类")
@Data
public class DeptModel {

    @ApiModelProperty(value = "主键")
    private Integer id;
    @ApiModelProperty(value = "部门名称")
    private String deptName;
    @ApiModelProperty(value = "上级ID")
    private Integer parentId;
    @ApiModelProperty(value = "否是可用 1: 可用0:不可用")
    private Integer usable;
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @ApiModelProperty(value = "是否删除0:否1:是")
    private Integer isDelete;
}