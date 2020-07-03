package cdu.lmz.dao;

import cdu.lmz.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create with IntelliJ IDEA
 * User:lmz
 * Date:2020/06/15
 * Description
 * Version:1.0
 */
//代理；Spring代理执行
@Repository
public interface UserDao {
//   用户
    List<User> findAll();
    User findById(int id);
    List<User> findByName(String name);
    User check(User user);
    int insert(User user);
    int del(int id);
    int mod(User user);



//    List<User> findall();
//    User check(User user);
//    int add(User user);
//    int modify(User user);
//    int count();
}
