package com.chq.project.cloud.system.service;

import com.chq.project.cloud.common.entity.system.UserModel;
import com.chq.project.cloud.system.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 描述：用户管理 服务实现层
 *
 * @author CHQ
 * @date 2020-05-12
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    /**
     * 查询数据
     *
     * @return
     */
    public List<UserModel> selectList(Map<String, Object> searchMap) {
        return userDao.selectList(searchMap);
    }


    /**
     * 新增数据
     *
     * @param model
     */
    public Integer insert(UserModel model) {
        return userDao.insert(model);
    }

    /**
     * 更新数据
     *
     * @param model
     */
    public Integer update(UserModel model) {
        return userDao.update(model);
    }

    /**
     * 删除数据
     *
     * @param id
     */
    public Integer delete(Integer id) {
        return userDao.delete(id);
    }

    /**
     * 根据ID查询数据
     *
     * @param id
     */
    public UserModel getById(Integer id) {
        return userDao.getById(id);
    }

}
