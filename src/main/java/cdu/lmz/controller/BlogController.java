package cdu.lmz.controller;

import cdu.lmz.model.Blog;
import cdu.lmz.model.Comment;
import cdu.lmz.model.User;
import cdu.lmz.service.BlogService;
import cdu.lmz.service.CommentService;
import cdu.lmz.service.UserService;
import com.sun.javafx.collections.MappingChange;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Create with IntelliJ IDEA
 * User:lmz
 * Date:2020/06/23
 * Description
 * Version:1.0
 */
@Controller
public class BlogController {
    @Resource
    UserService userService;
    @Resource
    BlogService blogService;
    @Resource
    CommentService commentService;

    @GetMapping("write")
    public ModelAndView write1(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String user_id = request.getParameter("user_id");
        int id = Integer.parseInt(user_id);
        User user = userService.findById(id);
        mv.addObject("user", user);
        mv.setViewName("write");
        return mv;
    }

    @PostMapping("write")
    public ModelAndView write2(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String user_id = request.getParameter("user_id");
        String title = request.getParameter("title");
        String context = request.getParameter("context");
        int id = Integer.parseInt(user_id);
        System.out.println("title:" + title);
        System.out.println("context:" + context);
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContext(context);
        blog.setUser_id(id);

        //获取博客发表时间
        Date time = new Date();
        java.sql.Date data = new java.sql.Date(time.getTime());
        blog.setWriteTime(data);
        //添加博客到数据库中
        blogService.insert(blog);
        //查找所有该用户所写的博客
        List<Blog> blogs = blogService.findByUserId(id);
        User user = userService.findById(id);
        if (blogs != null) {
            user.setBlogList(blogs);
            mv.addObject("user", user);
        } else {


        }
        mv.setViewName("myblog");
        return mv;
    }


    @GetMapping("myBlog")
    public ModelAndView myBlog1(HttpServletRequest request) {
        String id = request.getParameter("user_id");
        ModelAndView mv = new ModelAndView();
        if (id != null) {
            System.out.println("user_id  :" + id);
            Integer user_id = Integer.parseInt(id);
            List<Blog> blogs = blogService.findByUserId(user_id);
            User user = userService.findById(user_id);
            user.setBlogList(blogs);
            mv.addObject("user", user);
        } else {
            System.out.println("null...............id");
        }
        mv.setViewName("myblog");
        return mv;
    }

    @GetMapping("xxblog")
    public ModelAndView xxhome(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("user_id");
        String my_id = request.getParameter("my_id");
        if (!my_id.isEmpty()) {
            int mid = Integer.parseInt(my_id);
            User my = userService.findById(mid);
            mv.addObject("my", my);
        }
//            System.out.println("user_id  :" + id);
        Integer user_id = Integer.parseInt(id);
//            List<Blog> blogs = blogService.findByUserId(user_id);
        User user = userService.findById(user_id);
//            user.setBlogList(blogs);
        mv.addObject("user", user);

        mv.setViewName("xxblog");
        return mv;
    }

    @GetMapping("showblog")
    public ModelAndView showblog1(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String blog_id = request.getParameter("blog_id");

        if (!request.getParameter("my_id").isEmpty()) {
            String my_id = request.getParameter("my_id");
            int mid = Integer.parseInt(my_id);
            User u = userService.findById(mid);
            mv.addObject("u", u);
        }

        int bid = Integer.parseInt(blog_id);
        Blog blog = blogService.findById(bid);
        mv.addObject("blog", blog);
        User user = userService.findById(blog.getUser_id());
        mv.addObject("user", user);
        Map<Comment, User> map = new HashMap<>();
        if (blog.getCommentList() != null) {
            List<Comment> comments = blog.getCommentList();
            for (Comment c : comments) {
                User us = userService.findById(c.getUser_id());
                map.put(c, us);
            }
            mv.addObject("map", map);
        }


        mv.setViewName("showblog");
        return mv;
    }

    @PostMapping("findTitle")
    public ModelAndView findTitle(String title, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("title", title);
        List<Blog> blogs = blogService.findByTitle(title);
        Map<Blog, User> map = new HashMap<>();
        for (Blog b : blogs) {
            User user = userService.findById(b.getUser_id());
            map.put(b, user);
            mv.addObject("map", map);

        }

        String user_id = request.getParameter("user_id");
        if (!user_id.isEmpty()) {
            System.out.println("user ..............cun.........zai");
            int id = Integer.parseInt(user_id);
            User my = userService.findById(id);
            mv.addObject("my", my);
            mv.setViewName("home");
        } else {
            mv.setViewName("findBlog");
        }
        return mv;
    }

    @PostMapping("modtitle")
    public ModelAndView modTitle(String title, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
//        mv.addObject("title",title);
        String blog_id = request.getParameter("blog_id");
        int bid = Integer.parseInt(blog_id);
        System.out.println("mod:"+bid);
        System.out.println("title:"+title);
        Blog blog = blogService.findById(bid);
        blog.setTitle(title);
        blogService.mod(blog);
        String user_id = request.getParameter("user_id");

        int id = Integer.parseInt(user_id);
        User my = userService.findById(id);
        mv.addObject("my", my);
        List<Blog> blogs = blogService.findByUserId(id);
        User user = userService.findById(id);
        user.setBlogList(blogs);
        mv.addObject("user", user);
        mv.setViewName("myblog");

        return mv;
    }
    @GetMapping("delblog")
    public ModelAndView delblog( HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
//        mv.addObject("title",title);
        String blog_id = request.getParameter("blog_id");
        int bid = Integer.parseInt(blog_id);

        blogService.del(bid);
        String user_id = request.getParameter("user_id");

        int id = Integer.parseInt(user_id);
        User my = userService.findById(id);
        mv.addObject("my", my);
        List<Blog> blogs = blogService.findByUserId(id);
        User user = userService.findById(id);
        user.setBlogList(blogs);
        mv.addObject("user", user);
        mv.setViewName("myblog");

        return mv;
    }

    @GetMapping("allblog")
    public ModelAndView allblog( HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
//        String blog_id = request.getParameter("blog_id");
//        int bid = Integer.parseInt(blog_id);
        String user_id = request.getParameter("user_id");

        int id = Integer.parseInt(user_id);
        User my = userService.findById(id);
        mv.addObject("my", my);


        List<User> users = userService.findAll();
        for (User u:users ) {
            List<Blog> blogs = blogService.findByUserId(u.getId());
            u.setBlogList(blogs);
        }
        mv.addObject("users",users);

        mv.setViewName("findallblog");

        return mv;
    }
    @PostMapping("mfindTitle")
    public ModelAndView mfindTitle(String title, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("title", title);
        List<Blog> blogs = blogService.findByTitle(title);
        Map<Blog, User> map = new HashMap<>();
        for (Blog b : blogs) {
            User user = userService.findById(b.getUser_id());
            map.put(b, user);
            mv.addObject("map", map);

        }
        String user_id = request.getParameter("user_id");


            int id = Integer.parseInt(user_id);
            User my = userService.findById(id);
            mv.addObject("my", my);


            mv.setViewName("findallblog");

        return mv;
    }
    @GetMapping("mdelblog")
    public ModelAndView mdelblog( HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String blog_id = request.getParameter("blog_id");
        int bid = Integer.parseInt(blog_id);
        blogService.del(bid);
        String user_id = request.getParameter("my_id");

        int id = Integer.parseInt(user_id);
        User my = userService.findById(id);
        mv.addObject("my", my);


        List<User> users = userService.findAll();
        for (User u:users ) {
            List<Blog> blogs = blogService.findByUserId(u.getId());
            u.setBlogList(blogs);
        }
        mv.addObject("users",users);

        mv.setViewName("findallblog");

        return mv;
    }

}
