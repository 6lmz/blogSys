package cdu.lmz.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create with IntelliJ IDEA
 * User:lmz
 * Date:2020/06/18
 * Description
 * Version:1.0
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("loginInerceptor");
        if(request.getSession().getAttribute("user") == null){
//            response.sendRedirect(request.getContextPath()+"/login");
            System.out.println("user.......................");
        }
        return true;
    }
}
