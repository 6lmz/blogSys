package cdu.lmz.service.impl;

import cdu.lmz.dao.RoleDao;
import cdu.lmz.model.Role;
import cdu.lmz.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * User:lmz
 * Date:2020/06/23
 * Description
 * Version:1.0
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    RoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public List<Role> findByUserId(int id) {
        return roleDao.findByUserId(id);
    }

    @Override
    public List<Role> findByPower(String power) {
        return roleDao.findByPower(power);
    }

    @Override
    public int insert(Role role) {
        return roleDao.insert(role);
    }

    @Override
    public int del(int id) {
        return roleDao.del(id);
    }

    @Override
    public int mod(Role role) {
        return roleDao.mod(role);
    }
}
