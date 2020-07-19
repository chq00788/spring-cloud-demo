package com.chq.project.cloud.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.chq.project.cloud.common.utils.SearchUtil;
import com.chq.project.cloud.common.entity.PageResponse;
import com.chq.project.cloud.common.entity.Response;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.chq.project.cloud.system.service.DeptService;
import com.chq.project.cloud.common.entity.system.DeptModel;


import java.util.List;


/**
* 描述：部门管理控制层
* @author CHQ
* @date 2020-05-14
*/
@Api(tags = {"部门管理操作接口"}, description = "部门管理操作接口")
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Resource
    private DeptService deptService;


    @ApiOperation(value = "查询分页信息", notes = "查询分页信息",httpMethod = "GET")
    @GetMapping(value = "/getListByPage/{page}/{limit}/{param}")
    public PageResponse<List<DeptModel>> getListByPage(@PathVariable("page") Integer page,
                                                                @PathVariable("limit") Integer limit,
                                                                @PathVariable("param") String param) {

            PageHelper.startPage(page, limit);
            PageHelper.orderBy("id desc");
            List<DeptModel> list = deptService.selectList(SearchUtil.getSearchMap(param));
            PageInfo<DeptModel> pageInfo = new PageInfo<>(list);
            return PageResponse.ok(pageInfo);
    }

    @ApiOperation(value = "查询信息列表", notes = "查询信息列表",httpMethod = "GET")
    @GetMapping(value = "/getList/{param}")
    public Response<List<DeptModel>> getList(@PathVariable("param") String param) {
            List<DeptModel> list = deptService.selectList(SearchUtil.getSearchMap(param));
            return Response.ok(list);
    }

    @ApiOperation(value = "保存信息", notes = "保存信息",httpMethod = "POST")
    @PostMapping(value = "/save")
    public Response<String> save(@RequestBody DeptModel model) {
            deptService.insert(model);
            return Response.ok("保存成功");
    }

    @ApiOperation(value = "更新信息", notes = "更新信息",httpMethod = "POST")
    @PostMapping(value = "/update")
    public Response<String> update(@RequestBody DeptModel model) {
            deptService.update(model);
            return Response.ok("更新成功");
    }

    @ApiOperation(value = "删除信息", notes = "删除信息", httpMethod = "DELETE")
    @DeleteMapping(value = "/delete/{id}")
    public Response<String> delete(@PathVariable("id") Integer id) {
            deptService.delete(id);
            return Response.ok("删除成功");
    }

    @ApiOperation(value = "根据ID查询信息", notes = "根据ID查询信息",httpMethod = "GET")
    @GetMapping(value = "/getById/{id}")
    public Response<DeptModel> getById(@PathVariable("id") Integer id) {
            DeptModel model = deptService.getById(id);
            return Response.ok(model);
    }
}
