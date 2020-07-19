<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${package_name}.${module_dir}.dao.${table_name}Dao">

<#--字段-->
    <sql id="baseColumn">
    <#list columnNames as column>
        <#if column_index == (columnNames?size-1)>
        ${column}
        <#else>
        ${column},
        </#if>
    </#list>
    </sql>

<#--返回值-->
    <resultMap id="baseResultMap" type="${package_name}.common.entity.${module_dir}.${table_name}Model">
    <#list columnNames as column>
        <#if column == 'id'>
            <id property="id" column="id"/>
        <#else>
            <result property="${propertyNames[column_index]}" column="${column}"/>
        </#if>
    </#list>
    </resultMap>

    <sql id="selectiveWhere">
        <where>

        </where>
    </sql>


    <select id="selectList" resultMap="baseResultMap">
        SELECT
        <include refid="baseColumn"/>
        FROM ${table_name_small}
        <include refid="selectiveWhere"/>
    </select>

    <insert id="insert" parameterType="${package_name}.common.entity.${module_dir}.${table_name}Model">
        INSERT INTO ${table_name_small}
    <trim prefix="(" suffix=")" suffixOverrides="," >
    <#list columnNames as column>
        <#if column_index == (columnNames?size-1)>
            <#if column != 'id'>
            <if test="${propertyNames[column_index]} != null ">
            ${column}
            </if>
            </#if>
        <#else>
            <#if column != 'id'>
            <if test="${propertyNames[column_index]} != null ">
            ${column},
            </if>
            </#if>
        </#if>
    </#list>
    </trim>
    <trim prefix="values (" suffix=")" suffixOverrides="," >
    <#list columnNames as column>
        <#if column_index == (columnNames?size-1)>
            <#if column != 'id'>
            <if test="${propertyNames[column_index]} != null ">
            ${r'#'}{${propertyNames[column_index]}}
            </if>
            </#if>
        <#else>
            <#if column != 'id'>
            <if test="${propertyNames[column_index]} != null ">
            ${r'#'}{${propertyNames[column_index]}},
            </if>
            </#if>
        </#if>
    </#list>
    </trim>
    </insert>

    <update id="update" parameterType="${package_name}.common.entity.${module_dir}.${table_name}Model">
        UPDATE ${table_name_small}
        <set>
        <#list columnNames as column>
        <#if column != 'id'>
            <if test="${propertyNames[column_index]} != null ">
            ${column} = ${r'#'}{${propertyNames[column_index]}},
            </if>
        </#if>
        </#list>
        </set>
        WHERE id = ${r'#{id}'}
    </update>

    <delete id="delete" parameterType="integer">
        DELETE FROM ${table_name_small}
        WHERE id = ${r'#{id}'}
    </delete>

    <select id="getById" resultMap="baseResultMap">
        SELECT
        <include refid="baseColumn"/>
        FROM ${table_name_small}
        WHERE id = ${r'#{id}'}
    </select>

</mapper>