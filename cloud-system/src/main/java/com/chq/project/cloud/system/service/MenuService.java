package com.chq.project.cloud.system.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.chq.project.cloud.system.dao.MenuDao;
import com.chq.project.cloud.common.entity.system.MenuModel;
import java.util.Map;
import java.util.List;

/**
* 描述：菜单管理 服务实现层
* @author CHQ
* @date 2020-05-14
*/
@Service
public class MenuService{

    @Resource
    private MenuDao menuDao;

    /**
    * 查询数据
    *
    * @return
    */
    public List<MenuModel> selectList(Map<String, Object> searchMap) {
        return menuDao.selectList(searchMap);
    }


    /**
    * 新增数据
    *
    * @param model
    */
    public Integer insert(MenuModel model) {
        return menuDao.insert(model);
    }

    /**
    * 更新数据
    *
    * @param model
    */
    public Integer update(MenuModel model) {
        return menuDao.update(model);
    }

    /**
    * 删除数据
    *
    * @param id
    */
    public Integer delete(Integer id) {
        return menuDao.delete(id);
    }

    /**
    * 根据ID查询数据
    *
    * @param id
    */
    public MenuModel getById(Integer id) {
        return menuDao.getById(id);
    }
}