package com.chq.project.cloud.order.feign;

import com.chq.project.cloud.common.entity.Response;
import com.chq.project.cloud.common.entity.system.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户feign
 *
 * @author CHQ
 */
@Component
@FeignClient(value = "SYSTEM", fallback = UserFeignFallBackImpl.class)
public interface UserFeignService {

    /**
     * 根据ID查询用户信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/user/getById/{id}")
    public Response<UserModel> getById(@PathVariable("id") Integer id);
}
