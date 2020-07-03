package cdu.lmz.service;

import cdu.lmz.model.User;

import java.util.List;

/**
 * Create with IntelliJ IDEA
 * User:lmz
 * Date:2020/06/15
 * Description
 * Version:1.0
 */

public interface UserService {

    List<User> findAll();
    User findById(int id);
    List<User> findByName(String name);
    User check(User user);
    int insert(User user);
    int del(int id);
    int mod(User user);
//    List<User> findall();
//    User check(User user);
//    int count();
//    int add(User user);
//    int modify(User user);
}
