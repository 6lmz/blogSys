package cdu.lmz.controller;

import cdu.lmz.model.Blog;
import cdu.lmz.model.Comment;
import cdu.lmz.model.User;
import cdu.lmz.service.BlogService;
import cdu.lmz.service.CommentService;
import cdu.lmz.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create with IntelliJ IDEA
 * User:lmz
 * Date:2020/06/23
 * Description
 * Version:1.0
 */
@Controller
public class CommentController {
    @Resource
    UserService userService;
    @Resource
    CommentService commentService;
    @Resource
    BlogService blogService;

    @PostMapping("writeComment")
    public ModelAndView writeCom(Comment comment,HttpServletRequest request){
        ModelAndView mv = new ModelAndView();

//        获取该博客
        String blog_id = request.getParameter("blog_id");
        int bid = Integer.parseInt(blog_id);
        Blog blog = blogService.findById(bid);


//        获取博客的作者信息
        int uid = blog.getUser_id();
        User user = userService.findById(uid);
//        user.getBlogList().add(blog);

        //        添加评论
        comment.setBlog_id(bid);
        int my_id = comment.getUser_id();
        User my = userService.findById(my_id);
        Date time = new Date();
        java.sql.Date data=new java.sql.Date(time.getTime());
        comment.setContentTime(data);
        commentService.insert(comment);

        blog = blogService.findById(bid);
        mv.addObject("blog",blog);
        Map<Comment,User> map = new HashMap<>();
        if(blog.getCommentList()!=null){
            List<Comment> comments= blog.getCommentList();
            for (Comment c : comments) {
                User us = userService.findById(c.getUser_id());
                map.put(c,us);
            }
            mv.addObject("map",map);
        }
        mv.addObject("user", user);
        mv.addObject("u",my);
//        System.out.println("评论是否为空："+comment.getContent().isEmpty());
        mv.setViewName("showblog");
        return mv;
    }

    @GetMapping("myWriteCom")
    public ModelAndView woCanYuDePinglun(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        String user_id = request.getParameter("user_id");
        int id = Integer.parseInt(user_id);
        User user = userService.findById(id);
        mv.addObject("user",user);
        Map<Blog,Comment> map = new HashMap<>();
        for (Comment c: user.getCommentList()) {
            Blog blog = blogService.findById(c.getBlog_id());
            map.put(blog,c);
        }
        mv.addObject("map",map);
        mv.setViewName("wocanyudepinglun");
        return mv;
    }
    @GetMapping("delmypinglun")
    public ModelAndView delPinglun(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        String user_id = request.getParameter("user_id");
        String com_id = request.getParameter("com_id");
        int cid = Integer.parseInt(com_id);
        commentService.del(cid);
        int id = Integer.parseInt(user_id);
        User user = userService.findById(id);
        mv.addObject("user",user);
        Map<Blog,Comment> map = new HashMap<>();
        for (Comment c: user.getCommentList()) {
            Blog blog = blogService.findById(c.getBlog_id());
            map.put(blog,c);
        }
        mv.addObject("map",map);
        mv.setViewName("wocanyudepinglun");
        return mv;
    }


    @GetMapping("ComFrom")
    public ModelAndView woDeWenZhangPinglun(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        String user_id = request.getParameter("user_id");
        int id = Integer.parseInt(user_id);
        User user = userService.findById(id);
        List<Blog> blogs=user.getBlogList();
        for (Blog b: blogs) {
            List<Comment> comments = commentService.findByBlogId(b.getId());
            b.setCommentList(comments);
        }
        mv.addObject("blogs",blogs);
        mv.addObject("user",user);
        mv.setViewName("wodewenzhangpinglun");
        return mv;
    }
    @GetMapping("delmywenzhangpinglun")
    public ModelAndView delWenZhangPinglun(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        String user_id = request.getParameter("user_id");
        String com_id = request.getParameter("com_id");
        int cid = Integer.parseInt(com_id);
        commentService.del(cid);
        int id = Integer.parseInt(user_id);
        User user = userService.findById(id);
        List<Blog> blogs=user.getBlogList();
        for (Blog b: blogs) {
            List<Comment> comments = commentService.findByBlogId(b.getId());
            b.setCommentList(comments);
        }
        mv.addObject("blogs",blogs);
        mv.addObject("user",user);
        mv.setViewName("wodewenzhangpinglun");
        return mv;
    }

}
