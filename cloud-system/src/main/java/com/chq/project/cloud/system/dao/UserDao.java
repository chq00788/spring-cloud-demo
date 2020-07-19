package com.chq.project.cloud.system.dao;

import com.chq.project.cloud.common.entity.system.UserModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 描述：用户管理 Dao接口
 *
 * @author CHQ
 * @date 2020-05-12
 */
public interface UserDao {


    /**
     * 查询数据信息
     *
     * @param searchMap
     * @return
     */
    List<UserModel> selectList(Map<String, Object> searchMap);

    /**
     * 新增
     *
     * @param model
     * @return
     */
    Integer insert(UserModel model);

    /**
     * 更新
     *
     * @param model
     * @return
     */
    Integer update(UserModel model);

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
    UserModel getById(Integer id);

}
