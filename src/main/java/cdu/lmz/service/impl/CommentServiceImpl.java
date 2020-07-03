package cdu.lmz.service.impl;

import cdu.lmz.dao.CommentDao;
import cdu.lmz.model.Comment;
import cdu.lmz.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * User:lmz
 * Date:2020/06/28
 * Description
 * Version:1.0
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    CommentDao commentDao;

    @Override
    public List<Comment> findAll() {
        return commentDao.findAll();
    }

    @Override
    public List<Comment> findByUserId(int user_id) {
        return commentDao.findByUserId(user_id);
    }

    @Override
    public List<Comment> findByBlogId(int blog_id) {
        return commentDao.findByBlogId(blog_id);
    }

    @Override
    public List<Comment> findByBlogIdAndUserId(int blog_id, int user_id) {
        List<Comment> bcom = commentDao.findByBlogId(blog_id);
        List<Comment> ucom = commentDao.findByUserId(user_id);
        List<Comment> comments = null;
        for (Comment b:bcom) {
            for (Comment u:ucom) {
                if(u.equals(b)){
                    comments.add(u);
                }
            }
        }
        return comments;
    }


    @Override
    public int insert(Comment comment) {
        return commentDao.insert(comment);
    }

    @Override
    public int del(int id) {
        return commentDao.del(id);
    }

    @Override
    public int mod(Comment comment) {
        return commentDao.mod(comment);
    }
}
