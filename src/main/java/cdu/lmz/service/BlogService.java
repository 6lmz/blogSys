package cdu.lmz.service;

import cdu.lmz.model.Blog;

import java.util.List;

/**
 * Create with IntelliJ IDEA
 * User:lmz
 * Date:2020/06/23
 * Description
 * Version:1.0
 */
public interface BlogService {
    List<Blog> findAll();
    List<Blog> findByUserId(int user_id);
    List<Blog> findByTitle(String title);
    Blog findById(int id);
    int insert(Blog blog);
    int del(int id);
    int mod(Blog blog);
}
