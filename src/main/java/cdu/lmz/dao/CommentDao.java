package cdu.lmz.dao;

import cdu.lmz.model.Comment;
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
public interface CommentDao {
//    博客评论
    List<Comment> findAll();
    List<Comment> findByUserId(int user_id);
    List<Comment> findByBlogId(int blog_id);
    List<Comment> findByBlogIdAndUserId(int blog_id,int user_id);
    int insert(Comment comment);
    int del(int id);
    int mod(Comment comment);
}
