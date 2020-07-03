package cdu.lmz.service;

import cdu.lmz.model.Comment;

import java.util.List;

/**
 * Create with IntelliJ IDEA
 * User:lmz
 * Date:2020/06/28
 * Description
 * Version:1.0
 */
public interface CommentService {
    List<Comment> findAll();
    List<Comment> findByUserId(int user_id);
    List<Comment> findByBlogId(int blog_id);
    List<Comment> findByBlogIdAndUserId(int blog_id,int user_id);
    int insert(Comment comment);
    int del(int id);
    int mod(Comment comment);
}
