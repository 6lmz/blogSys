package cdu.lmz.service.impl;

import cdu.lmz.dao.BlogDao;
import cdu.lmz.dao.CommentDao;
import cdu.lmz.dao.RoleDao;
import cdu.lmz.dao.UserDao;
import cdu.lmz.model.Blog;
import cdu.lmz.model.Comment;
import cdu.lmz.model.Role;
import cdu.lmz.model.User;
import cdu.lmz.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * User:lmz
 * Date:2020/06/15
 * Description
 * Version:1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;
    @Resource
    RoleDao roleDao;
    @Resource
    CommentDao commentDao;
    @Resource
    BlogDao blogDao;
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public User check(User user) {
        return userDao.check(user);
    }

    @Override
    public int insert(User user) {
        int result=userDao.insert(user);
        int user_id = user.getId();
        List<Role> roleList = user.getRoleList();
        for (Role r : roleList  ) {
            r.setUser_id(user_id);
            roleDao.insert(r);
        }

        return result;
    }

    @Override
    public int del(int id) {
        List<Comment> commentList = commentDao.findByUserId(id);
        for (Comment c:commentList) {
            commentDao.del(c.getId());
        }
        List<Blog> blogs = blogDao.findByUserId(id);
        for (Blog b:blogs) {
            blogDao.del(b.getId());
        }
        List<Role> roleList = roleDao.findByUserId(id);
        for (Role r:roleList) {
            roleDao.del(r.getId());
        }
        return userDao.del(id);
    }

    @Override
    public int mod(User user) {
        return userDao.mod(user);
    }
}
