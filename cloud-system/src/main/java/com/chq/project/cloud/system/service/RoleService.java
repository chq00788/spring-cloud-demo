package com.chq.project.cloud.system.service;

import com.chq.project.cloud.common.entity.system.RoleMenuModel;
import com.chq.project.cloud.common.entity.system.RoleModel;
import com.chq.project.cloud.system.dao.RoleDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 描述：角色管理 服务实现层
 *
 * @author CHQ
 * @date 2020-05-14
 */
@Service
public class RoleService {

    @Resource
    private RoleDao roleDao;

    /**
     * 查询数据
     *
     * @return
     */
    public List<RoleModel> selectList(Map<String, Object> searchMap) {
        return roleDao.selectList(searchMap);
    }


    /**
     * 新增数据
     *
     * @param model
     */
    public Integer insert(RoleModel model) {
        return roleDao.insert(model);
    }

    /**
     * 更新数据
     *
     * @param model
     */
    public Integer update(RoleModel model) {
        return roleDao.update(model);
    }

    /**
     * 删除数据
     *
     * @param id
     */
    public Integer delete(Integer id) {
        return roleDao.delete(id);
    }

    /**
     * 根据ID查询数据
     *
     * @param id
     */
    public RoleModel getById(Integer id) {
        return roleDao.getById(id);
    }


    /**
     * 设置角色权限
     *
     * @param id
     * @param menuIdsStr
     */
    @Transactional(rollbackFor = Exception.class)
    public void setRoleMenus(Integer id, String menuIdsStr) {
        //删除已有角色权限信息
        roleDao.deleteRoleMenus(id);
        String[] menuIds = menuIdsStr.split(",");
        List<RoleMenuModel> list = new ArrayList<>();
        for (int i = 0; i < menuIds.length; i++) {
            RoleMenuModel model = new RoleMenuModel(id, Integer.valueOf(menuIds[i]));
            list.add(model);
        }
        roleDao.setRoleMenus(list);
    }

    /**
     * 查询角色权限ID
     *
     * @param id
     * @return
     */
    public List<Integer> getRoleMenuIds(Integer id) {
        return roleDao.getRoleMenuIds(id);
    }
}
