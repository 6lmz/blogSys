package cdu.lmz.service.impl;

import cdu.lmz.dao.BlogDao;
import cdu.lmz.model.Blog;
import cdu.lmz.service.BlogService;
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
public class BlogServicerImpl implements BlogService {
    @Resource
    BlogDao blogDao;
    @Override
    public List<Blog> findAll() {
        return blogDao.findAll();
    }

    @Override
    public List<Blog> findByUserId(int user_id) {
        return blogDao.findByUserId(user_id);
    }

    @Override
    public List<Blog> findByTitle(String title) {
        return blogDao.findByTitle(title);
    }

    @Override
    public Blog findById(int id) {
        return blogDao.findById(id);
    }

    @Override
    public int insert(Blog blog) {
        blogDao.insert(blog);
        return 0;
    }

    @Override
    public int del(int id) {
        return blogDao.del(id);
    }

    @Override
    public int mod(Blog blog) {
        return blogDao.mod(blog);
    }
}
