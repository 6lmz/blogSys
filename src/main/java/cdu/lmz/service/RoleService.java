package cdu.lmz.service;

import cdu.lmz.model.Role;

import java.util.List;

/**
 * Create with IntelliJ IDEA
 * User:lmz
 * Date:2020/06/23
 * Description
 * Version:1.0
 */
public interface RoleService {
    List<Role> findAll();
    List<Role> findByUserId(int id);
    List<Role> findByPower(String power);
    int insert(Role role);
    int del(int id);
    int mod(Role role);
}
