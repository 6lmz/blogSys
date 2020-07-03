package cdu.lmz.controller;

import cdu.lmz.model.Blog;
import cdu.lmz.model.Role;
import cdu.lmz.model.User;
import cdu.lmz.service.BlogService;
import cdu.lmz.service.RoleService;
import cdu.lmz.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * User:lmz
 * Date:2020/06/15
 * Description
 * Version:1.0
 */
@Controller("/user")
public class UserController {
    @Resource
    UserService userService;
    @Resource
    RoleService roleService;
    @Resource
    BlogService blogService;
    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        List<User> users = userService.findAll();
        for (User u:users ) {
            List<Blog> blogs = blogService.findByUserId(u.getId());
            u.setBlogList(blogs);
        }
        mv.addObject("users",users);

        mv.setViewName("index");
        return mv;
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @PostMapping("/login")
    public String login2( User user, HttpSession session){
        User u=userService.check(user);
        int num=0;
        if(u!=null){
        List<Role> roleList=roleService.findByUserId(u.getId());

            for (Role r:roleList) {
                if(r.getPower().equals("管理员")){
                    num=1;
                }
            }
            session.setAttribute("my",u);
            session.setAttribute("id",u.getId());
            session.setAttribute("num",num);
            return "home";
        }
        else {
            return "login";
        }

    }
    @GetMapping("/register")
    public String regist(){
        return "register";
    }
    @PostMapping("/register")
    public String register(User user)  {
//      添加日期
        Date time = new Date();
        java.sql.Date data1=new java.sql.Date(time.getTime());
        user.setRegisterTime(data1);
        System.out.println(data1);
        System.out.println(user.toString());
        userService.insert(user);
        return "login";
    }
    @GetMapping("/xxhome")
    public ModelAndView userhome(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        String user_id = request.getParameter("user_id");
        String my_id = request.getParameter("my_id");
        if(!my_id.isEmpty()) {
            int mid = Integer.parseInt(my_id);
            User my = userService.findById(mid);
            mv.addObject("my",my);
        }
        int id = Integer.parseInt(user_id);
        User user = userService.findById(id);
        mv.addObject("user",user);
        mv.setViewName("userhome");
        return mv;
    }


    @GetMapping("findAllLog")
    public String findAllLog1(){
        return "looklog";
    }

    @GetMapping("findAllUser")
    public ModelAndView findAllUser1(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        String my_id = request.getParameter("user_id");
        if(!my_id.isEmpty()) {
            int mid = Integer.parseInt(my_id);
            User my = userService.findById(mid);
            mv.addObject("my",my);
        }
        List<User> userList = userService.findAll();
        mv.addObject("userList",userList);
        mv.setViewName("alluser");
        return mv;
    }
    @GetMapping("deluser")
    public ModelAndView findAllUser2(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        String user_id = request.getParameter("user_id");
        int uid = Integer.parseInt(user_id);
        userService.del(uid);
        String my_id = request.getParameter("my_id");
        if(!my_id.isEmpty()) {
            int mid = Integer.parseInt(my_id);
            User my = userService.findById(mid);
            mv.addObject("my",my);
        }
        List<User> userList = userService.findAll();
        mv.addObject("userList",userList);
        mv.setViewName("alluser");
        return mv;
    }
    @PostMapping("finduser")
    public ModelAndView findAllUser2(String name,HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        String my_id = request.getParameter("user_id");
        if(!my_id.isEmpty()) {
            int mid = Integer.parseInt(my_id);
            User my = userService.findById(mid);
            mv.addObject("my",my);
        }
        List<User> userList = userService.findByName(name);
        mv.addObject("userList",userList);
        mv.setViewName("alluser");
        return mv;
    }

    @PostMapping("modpwd")
    public ModelAndView delUser(String password,HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        String user_id = request.getParameter("user_id");

        int uid = Integer.parseInt(user_id);
        User user = userService.findById(uid);
        System.out.println("pwd:"+password);
        user.setPassword(password);
        userService.mod(user);
        String my_id = request.getParameter("my_id");
        if(!my_id.isEmpty()) {
            int mid = Integer.parseInt(my_id);
            User my = userService.findById(mid);
            mv.addObject("my",my);
        }
        List<User> userList = userService.findAll();
        mv.addObject("userList",userList);
        mv.setViewName("alluser");
        return mv;
    }




























//    @Resource
//    UserService userService;
//
//    @GetMapping("/login")
//    public String index(){
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String login(User userparam, HttpSession session){
////        System.out.println(userparam.getName());
//        User user=userService.check(userparam);
//        if(user != null){
////            System.out.println(user.getName());
//            session.setAttribute("user",user);
////            List<User> userList = userService.findall();
////            session.setAttribute("userlist",userList);
//            return "home";
//        }else{
//            return"login";
//        }
//    }



//    @GetMapping("/userlist")
//    public String findAll(@RequestParam(defaultValue = "1")int pageNum, @RequestParam(defaultValue = "5") int pageSize, Model model,   HttpServletRequest request){
//        PageHelper.startPage(pageNum,pageSize);
//        List<User> userList = userService.findall();
//        PageInfo<User> pageInfo = new PageInfo(userList);
//        model.addAttribute("userlist",userList);
//        model.addAttribute("pageInfo",pageInfo);
//        request.setAttribute("userlist",userList);
////        List<Log> logList =  userService.findAll();
////        for (Log log:logList) {
////            System.out.println(log);
////        }
////        model.addAttribute("logList",logList);
////        System.out.println("-----------------------------------------------");
//        return "userlist";
//    }

//    @RequestMapping("/userlist")
//    public String findAll2(@RequestParam(defaultValue = "1")int pageNum, @RequestParam(defaultValue = "5") int pageSize, Model model,   HttpServletRequest request){
//        PageHelper.startPage(pageNum,pageSize);
//        List<User> userList = userService.findall();
//        PageInfo<User> pageInfo = new PageInfo(userList);
//        model.addAttribute("userlist",userList);
//        model.addAttribute("pageInfo",pageInfo);
//        request.setAttribute("userlist",userList);
////        List<Log> logList =  userService.findAll();
////        for (Log log:logList) {
////            System.out.println(log);
////        }
////        model.addAttribute("logList",logList);
////        System.out.println("-----------------------------------------------");
//        return "userlist";
//    }

//    @GetMapping("/add")
//    public String addPage(){
//        return "add";
//    }
//    @PostMapping("/add")
//    public String  add(User user,HttpSession sessio){
//        
//        userService.add(user,address);
//        List<User> userList = userService.findall();
//        sessio.setAttribute("userlist",userList);
//        return "userlist";
//    }

//    @GetMapping("mod")
//    public String modify(){
//        return "mod";
//    }
//    @PostMapping("/mod")
//    public String  mod(User user,HttpSession sessio){
//        userService.modify(user);
//        List<User> userList = userService.findall();
//        sessio.setAttribute("userlist",userList);
//        return "userlist";
//    }
//
//    @GetMapping("/register")
//    public String regist(){
//        return "register";
//    }
//    @PostMapping("/register")
//    public String register(User user, @RequestParam(value = "head",required = false)MultipartFile head) throws Exception {
////       添加图片
//        byte[] h = head.getBytes();
//        user.setHeader(h);
//
////      添加日期
//        Date time = new Date();
//        java.sql.Date data1=new java.sql.Date(time.getTime());
//        user.setRegisterTime(data1);
//
//
//        userService.add(user);
//        return "login";
//    }
}
