package com.chq.project.cloud.system.controller;

import com.chq.project.cloud.common.entity.PageResponse;
import com.chq.project.cloud.common.entity.Response;
import com.chq.project.cloud.common.entity.system.RoleModel;
import com.chq.project.cloud.common.utils.SearchUtil;
import com.chq.project.cloud.system.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * 描述：角色管理控制层
 *
 * @author CHQ
 * @date 2020-05-14
 */
@Api(tags = {"角色管理操作接口"}, description = "角色管理操作接口")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;


    @ApiOperation(value = "查询分页信息", notes = "查询分页信息", httpMethod = "GET")
    @GetMapping(value = "/getListByPage/{page}/{limit}/{param}")
    public PageResponse<List<RoleModel>> getListByPage(@PathVariable("page") Integer page,
                                                       @PathVariable("limit") Integer limit,
                                                       @PathVariable("param") String param) {

        PageHelper.startPage(page, limit);
        PageHelper.orderBy("id desc");
        List<RoleModel> list = roleService.selectList(SearchUtil.getSearchMap(param));
        PageInfo<RoleModel> pageInfo = new PageInfo<>(list);
        return PageResponse.ok(pageInfo);
    }

    @ApiOperation(value = "查询信息列表", notes = "查询信息列表", httpMethod = "GET")
    @GetMapping(value = "/getList/{param}")
    public Response<List<RoleModel>> getList(@PathVariable("param") String param) {
        List<RoleModel> list = roleService.selectList(SearchUtil.getSearchMap(param));
        return Response.ok(list);
    }

    @ApiOperation(value = "保存信息", notes = "保存信息", httpMethod = "POST")
    @PostMapping(value = "/save")
    public Response<String> save(@RequestBody RoleModel model) {
        roleService.insert(model);
        return Response.ok("保存成功");
    }

    @ApiOperation(value = "更新信息", notes = "更新信息", httpMethod = "POST")
    @PostMapping(value = "/update")
    public Response<String> update(@RequestBody RoleModel model) {
        roleService.update(model);
        return Response.ok("更新成功");
    }

    @ApiOperation(value = "删除信息", notes = "删除信息", httpMethod = "DELETE")
    @DeleteMapping(value = "/delete/{id}")
    public Response<String> delete(@PathVariable("id") Integer id) {
        roleService.delete(id);
        return Response.ok("删除成功");
    }

    @ApiOperation(value = "根据ID查询信息", notes = "根据ID查询信息", httpMethod = "GET")
    @GetMapping(value = "/getById/{id}")
    public Response<RoleModel> getById(@PathVariable("id") Integer id) {
        RoleModel model = roleService.getById(id);
        return Response.ok(model);
    }


    @ApiOperation(value = "设置角色权限信息", notes = "设置角色权限信息", httpMethod = "POST")
    @PostMapping(value = "/setRoleMenus")
    public Response<String> setRoleMenus(@RequestBody RoleModel model) {
        if (null == model.getId() || StringUtils.isEmpty(model.getMenuIds())) {
            return Response.fail("参数缺失");
        }
        roleService.setRoleMenus(model.getId(), model.getMenuIds());
        return Response.ok("保存成功");
    }

    @ApiOperation(value = "查询角色权限ID", notes = "查询角色权限ID", httpMethod = "GET")
    @GetMapping(value = "/getRoleMenuIds/{id}")
    public Response<List<Integer>> getRoleMenuIds(@PathVariable("id") Integer id) {
        List<Integer> list = roleService.getRoleMenuIds(id);
        return Response.ok(list);
    }
}
