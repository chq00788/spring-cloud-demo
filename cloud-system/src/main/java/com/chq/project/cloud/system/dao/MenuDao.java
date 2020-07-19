package com.chq.project.cloud.system.dao;
import com.chq.project.cloud.common.entity.system.MenuModel;
import java.util.Map;
import java.util.List;
/**
* 描述：菜单管理 Dao接口
* @author CHQ
* @date 2020-05-14
*/
public interface MenuDao {


    /**
    * 查询数据信息
    *
    * @param searchMap
    * @return
    */
    List<MenuModel> selectList(Map<String, Object> searchMap);

    /**
    * 新增
    *
    * @param model
    * @return
    */
    Integer insert(MenuModel model);

    /**
    * 更新
    *
    * @param model
    * @return
    */
    Integer update(MenuModel model);

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
    MenuModel getById(Integer id);

}