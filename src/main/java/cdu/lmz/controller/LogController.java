package cdu.lmz.controller;

import cdu.lmz.model.Log;
import cdu.lmz.model.User;
import cdu.lmz.service.LogService;
import cdu.lmz.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * User:lmz
 * Date:2020/06/18
 * Description
 * Version:1.0
 */
@Controller
public class LogController {
    @Resource
    LogService logServicer;
    @Resource
    UserService userService;
    @GetMapping("/alllog")
    public ModelAndView findAll(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        String user_id = request.getParameter("user_id");
        int id=Integer.parseInt(user_id);
        User user = userService.findById(id);
        mv.addObject("user",user);
        List<Log> logList =  logServicer.findAll();

        for (Log log:logList) {
            System.out.println(log);
        }
        mv.addObject("logs",logList);
        mv.setViewName("logs");
        System.out.println("-----------------------------------------------");
        return mv;
    }


}
