package com.chq.project.cloud.common.entity.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 描述：测试实体类
* @author CHQ
* @date 2020-05-12
*/
@ApiModel("测试实体类")
@Data
public class TestModel {

    @ApiModelProperty(value = "主键")
    private Integer id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "编号")
    private String code;
}