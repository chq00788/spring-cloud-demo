package com.chq.project.cloud.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.chq.project.cloud.common.utils.SearchUtil;
import com.chq.project.cloud.common.entity.PageResponse;
import com.chq.project.cloud.common.entity.Response;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.chq.project.cloud.system.service.MenuService;
import com.chq.project.cloud.common.entity.system.MenuModel;


import java.util.List;


/**
* 描述：菜单管理控制层
* @author CHQ
* @date 2020-05-14
*/
@Api(tags = {"菜单管理操作接口"}, description = "菜单管理操作接口")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private MenuService menuService;


    @ApiOperation(value = "查询分页信息", notes = "查询分页信息",httpMethod = "GET")
    @GetMapping(value = "/getListByPage/{page}/{limit}/{param}")
    public PageResponse<List<MenuModel>> getListByPage(@PathVariable("page") Integer page,
                                                                @PathVariable("limit") Integer limit,
                                                                @PathVariable("param") String param) {

            PageHelper.startPage(page, limit);
            PageHelper.orderBy("id desc");
            List<MenuModel> list = menuService.selectList(SearchUtil.getSearchMap(param));
            PageInfo<MenuModel> pageInfo = new PageInfo<>(list);
            return PageResponse.ok(pageInfo);
    }

    @ApiOperation(value = "查询信息列表", notes = "查询信息列表",httpMethod = "GET")
    @GetMapping(value = "/getList/{param}")
    public Response<List<MenuModel>> getList(@PathVariable("param") String param) {
            List<MenuModel> list = menuService.selectList(SearchUtil.getSearchMap(param));
            return Response.ok(list);
    }

    @ApiOperation(value = "保存信息", notes = "保存信息",httpMethod = "POST")
    @PostMapping(value = "/save")
    public Response<String> save(@RequestBody MenuModel model) {
            menuService.insert(model);
            return Response.ok("保存成功");
    }

    @ApiOperation(value = "更新信息", notes = "更新信息",httpMethod = "POST")
    @PostMapping(value = "/update")
    public Response<String> update(@RequestBody MenuModel model) {
            menuService.update(model);
            return Response.ok("更新成功");
    }

    @ApiOperation(value = "删除信息", notes = "删除信息", httpMethod = "DELETE")
    @DeleteMapping(value = "/delete/{id}")
    public Response<String> delete(@PathVariable("id") Integer id) {
            menuService.delete(id);
            return Response.ok("删除成功");
    }

    @ApiOperation(value = "根据ID查询信息", notes = "根据ID查询信息",httpMethod = "GET")
    @GetMapping(value = "/getById/{id}")
    public Response<MenuModel> getById(@PathVariable("id") Integer id) {
            MenuModel model = menuService.getById(id);
            return Response.ok(model);
    }
}