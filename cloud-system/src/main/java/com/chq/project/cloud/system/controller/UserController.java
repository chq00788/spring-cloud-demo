package com.chq.project.cloud.system.controller;

import com.chq.project.cloud.common.entity.PageResponse;
import com.chq.project.cloud.common.entity.Response;
import com.chq.project.cloud.common.entity.system.UserModel;
import com.chq.project.cloud.common.utils.SearchUtil;
import com.chq.project.cloud.system.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * 描述：用户管理控制层
 *
 * @author CHQ
 * @date 2020-05-12
 */
@Api(tags = {"用户管理操作接口"}, description = "用户管理操作接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    @ApiOperation(value = "查询分页信息", notes = "查询分页信息", httpMethod = "GET")
    @GetMapping(value = "/getListByPage/{page}/{limit}/{param}")
    public PageResponse<List<UserModel>> getListByPage(@PathVariable("page") Integer page,
                                                       @PathVariable("limit") Integer limit,
                                                       @PathVariable("param") String param) {

        PageHelper.startPage(page, limit);
        PageHelper.orderBy("id desc");
        List<UserModel> list = userService.selectList(SearchUtil.getSearchMap(param));
        PageInfo<UserModel> pageInfo = new PageInfo<>(list);
        return PageResponse.ok(pageInfo);
    }

    @ApiOperation(value = "查询信息列表", notes = "查询信息列表", httpMethod = "GET")
    @GetMapping(value = "/getList/{param}")
    public Response<List<UserModel>> getList(@PathVariable("param") String param) {
        List<UserModel> list = userService.selectList(SearchUtil.getSearchMap(param));
        return Response.ok(list);
    }

    @ApiOperation(value = "保存信息", notes = "保存信息", httpMethod = "POST")
    @PostMapping(value = "/save")
    public Response<String> save(@RequestBody UserModel model) {
        userService.insert(model);
        return Response.ok("保存成功");
    }

    @ApiOperation(value = "更新信息", notes = "更新信息", httpMethod = "POST")
    @PostMapping(value = "/update")
    public Response<String> update(@RequestBody UserModel model) {
        userService.update(model);
        return Response.ok("更新成功");
    }

    @ApiOperation(value = "删除信息", notes = "删除信息", httpMethod = "DELETE")
    @DeleteMapping(value = "/delete/{id}")
    public Response<String> delete(@PathVariable("id") Integer id) {
        userService.delete(id);
        return Response.ok("删除成功");
    }

    @ApiOperation(value = "根据ID查询信息", notes = "根据ID查询信息", httpMethod = "GET")
    @GetMapping(value = "/getById/{id}")
    public Response<UserModel> getById(@PathVariable("id") Integer id) {
        UserModel model = userService.getById(id);
        return Response.ok(model);
    }

}
