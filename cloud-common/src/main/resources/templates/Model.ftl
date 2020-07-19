package ${package_name}.common.entity.${module_dir};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
<#if model_column?exists>
    <#list model_column as model>
        <#if model.columnType = 'DATETIME' || model.columnType = 'TIMESTAMP'>
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
        </#if>
        <#if model.columnType = 'DECIMAL' >
import java.math.BigDecimal;
        </#if>
    </#list>
</#if>

/**
* 描述：${table_annotation}实体类
* @author ${author}
* @date ${date}
*/
@ApiModel("${table_annotation}实体类")
@Data
public class ${table_name}Model {

<#if model_column?exists>
    <#list model_column as model>
    @ApiModelProperty(value = "${model.columnComment!}")
    <#if model.columnType = 'BIGINT'>
    private Long ${model.changeColumnName};
    </#if>
    <#if model.columnType = 'INT'>
    private Integer ${model.changeColumnName};
    </#if>
    <#if model.columnType = 'VARCHAR'>
    private String ${model.changeColumnName};
    </#if>
    <#if model.columnType = 'DATETIME' || model.columnType = 'TIMESTAMP'>
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ${model.changeColumnName};
    </#if>
    <#if  model.columnType = 'DATE'>
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date ${model.changeColumnName};
    </#if>
    <#if model.columnType = 'FLOAT'>
    private Float ${model.changeColumnName};
    </#if>
    <#if model.columnType = 'DOUBLE'>
    private Double ${model.changeColumnName};
    </#if>
    <#if model.columnType = 'DECIMAL'>
    private BigDecimal ${model.changeColumnName};
    </#if>
    <#if model.columnType = 'CHAR'>
    private char ${model.changeColumnName};
    </#if>
    </#list>
</#if>
}