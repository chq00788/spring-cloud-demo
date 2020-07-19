package com.chq.project.cloud.order.dao;

import com.chq.project.cloud.common.entity.order.TestModel;

import java.util.List;
import java.util.Map;

/**
 * 描述：测试 Dao接口
 *
 * @author CHQ
 * @date 2020-05-12
 */
public interface TestDao {


    /**
     * 查询数据信息
     *
     * @param searchMap
     * @return
     */
    List<TestModel> selectList(Map<String, Object> searchMap);

    /**
     * 新增
     *
     * @param model
     * @return
     */
    Integer insert(TestModel model);

    /**
     * 更新
     *
     * @param model
     * @return
     */
    Integer update(TestModel model);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    TestModel getById(Integer id);

}