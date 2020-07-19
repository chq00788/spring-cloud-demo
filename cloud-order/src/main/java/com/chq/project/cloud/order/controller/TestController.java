package com.chq.project.cloud.order.controller;

import com.chq.project.cloud.common.entity.PageResponse;
import com.chq.project.cloud.common.entity.Response;
import com.chq.project.cloud.common.entity.order.TestModel;
import com.chq.project.cloud.common.utils.SearchUtil;
import com.chq.project.cloud.order.service.TestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * 描述：测试控制层
 *
 * @author CHQ
 * @date 2020-05-12
 */
@Api(tags = {"测试操作接口"}, description = "测试操作接口")
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestService testService;


    @ApiOperation(value = "查询分页信息", notes = "查询分页信息", httpMethod = "GET")
    @GetMapping(value = "/getListByPage/{page}/{limit}/{param}")
    public PageResponse<List<TestModel>> getListByPage(@PathVariable("page") Integer page,
                                                       @PathVariable("limit") Integer limit,
                                                       @PathVariable("param") String param) {

        PageHelper.startPage(page, limit);
        PageHelper.orderBy("id desc");
        List<TestModel> list = testService.selectList(SearchUtil.getSearchMap(param));
        PageInfo<TestModel> pageInfo = new PageInfo<>(list);
        return PageResponse.ok(pageInfo);
    }

    @ApiOperation(value = "查询信息列表", notes = "查询信息列表", httpMethod = "GET")
    @GetMapping(value = "/getList/{param}")
    public Response<List<TestModel>> getList(@PathVariable("param") String param) {
        List<TestModel> list = testService.selectList(SearchUtil.getSearchMap(param));
        return Response.ok(list);
    }

    @ApiOperation(value = "保存信息", notes = "保存信息", httpMethod = "POST")
    @PostMapping(value = "/save")
    public Response<String> save(@RequestBody TestModel model) {
        testService.insert(model);
        return Response.ok("保存成功");
    }

    @ApiOperation(value = "更新信息", notes = "更新信息", httpMethod = "POST")
    @PostMapping(value = "/update")
    public Response<String> update(@RequestBody TestModel model) {
        testService.update(model);
        return Response.ok("更新成功");
    }

    @ApiOperation(value = "删除信息", notes = "删除信息", httpMethod = "DELETE")
    @DeleteMapping(value = "/delete/{id}")
    public Response<String> delete(@PathVariable("id") Integer id) {
        testService.delete(id);
        return Response.ok("删除成功");
    }

    @ApiOperation(value = "根据ID查询信息", notes = "根据ID查询信息", httpMethod = "GET")
    @GetMapping(value = "/getById/{id}")
    public Response<TestModel> getById(@PathVariable("id") Integer id) {
        TestModel model = testService.getById(id);
        return Response.ok(model);
    }
}