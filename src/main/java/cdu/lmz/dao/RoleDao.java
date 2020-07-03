package cdu.lmz.dao;

import cdu.lmz.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create with IntelliJ IDEA
 * User:lmz
 * Date:2020/06/18
 * Description
 * Version:1.0
 */
@Repository
public interface RoleDao {
//   角色权限
    List<Role> findAll();
    List<Role> findByUserId(int id);
    List<Role> findByPower(String power);
    int insert(Role role);
    int del(int id);
    int mod(Role role);


//    List<Role> findall();
//    int insert(List<Role> roleList);
//    List<Role> findByUserId(int user_id);


}
