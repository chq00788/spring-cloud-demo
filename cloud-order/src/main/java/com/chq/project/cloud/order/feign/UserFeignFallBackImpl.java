package com.chq.project.cloud.order.feign;

import com.chq.project.cloud.common.entity.Response;
import com.chq.project.cloud.common.entity.system.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 熔断处理类
 *
 * @author CHQ
 */
@Slf4j
@Component
public class UserFeignFallBackImpl implements UserFeignService {


    @Override
    public Response<UserModel> getById(Integer id) {
        log.info("触发熔断");
        return Response.fail("触发熔断");
    }
}
