package com.chq.project.cloud.system.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.chq.project.cloud.system.dao.DeptDao;
import com.chq.project.cloud.common.entity.system.DeptModel;
import java.util.Map;
import java.util.List;

/**
* 描述：部门管理 服务实现层
* @author CHQ
* @date 2020-05-14
*/
@Service
public class DeptService{

    @Resource
    private DeptDao deptDao;

    /**
    * 查询数据
    *
    * @return
    */
    public List<DeptModel> selectList(Map<String, Object> searchMap) {
        return deptDao.selectList(searchMap);
    }


    /**
    * 新增数据
    *
    * @param model
    */
    public Integer insert(DeptModel model) {
        return deptDao.insert(model);
    }

    /**
    * 更新数据
    *
    * @param model
    */
    public Integer update(DeptModel model) {
        return deptDao.update(model);
    }

    /**
    * 删除数据
    *
    * @param id
    */
    public Integer delete(Integer id) {
        return deptDao.delete(id);
    }

    /**
    * 根据ID查询数据
    *
    * @param id
    */
    public DeptModel getById(Integer id) {
        return deptDao.getById(id);
    }
}