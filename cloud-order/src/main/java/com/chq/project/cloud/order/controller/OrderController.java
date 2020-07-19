package com.chq.project.cloud.order.controller;

import com.chq.project.cloud.common.entity.Response;
import com.chq.project.cloud.common.entity.system.UserModel;
import com.chq.project.cloud.order.feign.UserFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单
 *
 * @author CHQ
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private UserFeignService userFeignService;

    /**
     * 查询用户信息
     *
     * @return
     */
    @GetMapping(value = "/getById/{id}")
    public Response<UserModel> getById(@PathVariable("id") Integer id) {
        return userFeignService.getById(id);
    }
}
