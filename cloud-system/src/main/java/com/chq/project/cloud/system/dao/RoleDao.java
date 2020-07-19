package com.chq.project.cloud.system.dao;

import com.chq.project.cloud.common.entity.system.RoleMenuModel;
import com.chq.project.cloud.common.entity.system.RoleModel;

import java.util.List;
import java.util.Map;

/**
 * 描述：角色管理 Dao接口
 *
 * @author CHQ
 * @date 2020-05-14
 */
public interface RoleDao {


    /**
     * 查询数据信息
     *
     * @param searchMap
     * @return
     */
    List<RoleModel> selectList(Map<String, Object> searchMap);

    /**
     * 新增
     *
     * @param model
     * @return
     */
    Integer insert(RoleModel model);

    /**
     * 更新
     *
     * @param model
     * @return
     */
    Integer update(RoleModel model);

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
    RoleModel getById(Integer id);

    /**
     * 设置角色权限
     *
     * @param list
     * @return
     */
    Integer setRoleMenus(List<RoleMenuModel> list);

    /**
     * 删除角色权限信息
     *
     * @param id
     * @return
     */
    Integer deleteRoleMenus(Integer id);

    /**
     * 查询角色权限ID
     * @param id
     * @return
     */
    List<Integer> getRoleMenuIds(Integer id);
}
