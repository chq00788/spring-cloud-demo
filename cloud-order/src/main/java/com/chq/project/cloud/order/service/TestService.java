package com.chq.project.cloud.order.service;

import com.chq.project.cloud.common.entity.order.TestModel;
import com.chq.project.cloud.order.dao.TestDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 描述：测试 服务实现层
 *
 * @author CHQ
 * @date 2020-05-12
 */
@Service
public class TestService {

    @Resource
    private TestDao testDao;

    /**
     * 查询数据
     *
     * @return
     */
    public List<TestModel> selectList(Map<String, Object> searchMap) {
        return testDao.selectList(searchMap);
    }


    /**
     * 新增数据
     *
     * @param model
     */
    public Integer insert(TestModel model) {
        return testDao.insert(model);
    }

    /**
     * 更新数据
     *
     * @param model
     */
    public Integer update(TestModel model) {
        return testDao.update(model);
    }

    /**
     * 删除数据
     *
     * @param id
     */
    public Integer delete(Integer id) {
        return testDao.delete(id);
    }

    /**
     * 根据ID查询数据
     *
     * @param id
     */
    public TestModel getById(Integer id) {
        return testDao.getById(id);
    }
}