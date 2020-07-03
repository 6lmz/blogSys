package cdu.lmz.dao;

import cdu.lmz.model.Blog;
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
public interface BlogDao {
//    博文
    List<Blog> findAll();
    List<Blog> findByUserId(int user_id);
    List<Blog> findByTitle(String title);
    Blog findById(int id);
    int insert(Blog blog);
    int del(int id);
    int mod(Blog blog);
}
