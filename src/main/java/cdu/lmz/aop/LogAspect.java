package cdu.lmz.aop;

import cdu.lmz.model.Log;
import cdu.lmz.model.User;
import cdu.lmz.service.LogService;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;


@Component
@Aspect
public class LogAspect {
    @Resource
    private LogService logService;

    @Pointcut("execution(* cdu.lmz.service.UserService.check(..))")
    public void pointCutLogin(){

        System.out.println("loginCut.........");
    }
    @AfterReturning(pointcut = "pointCutLogin()",returning = "user")
    public void afterLogin(User user){
        System.out.println("----------------AOP:登录-----------------");
        if (user!=null){
            Log log = new Log();
            log.setUser(user);
            log.setUser_id(user.getId());
            log.setOperate("用户登录");
            log.setOperateTime(new Date());
            System.out.println("添加登录日志：" +logService.insert(log)+": "+log);
        }
    }
}
