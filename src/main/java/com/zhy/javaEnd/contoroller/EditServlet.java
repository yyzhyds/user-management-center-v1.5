package com.zhy.javaEnd.contoroller;

import com.zhy.javaEnd.model.User;
import com.zhy.javaEnd.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* @description TODO
* @author Lenovo
* @date 7/6/2023 上午10:00
* @version 1.0
*/
@WebServlet("/updateUser")
public class EditServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("username");
        String pwd = req.getParameter("password");
        String phone = req.getParameter("s_phone");
        String email = req.getParameter("s_email");
        int uid = Integer.parseInt(id);

        User user = new User(uid,name, pwd, phone, email);
        UserService us = new UserService();
        int i = us.updateUser(user);
        System.out.println(user);
        if(i>0){
            //sqlSession.commit();
            System.out.println("成功");

        }else {
            System.out.println("失败");
        }
        resp.sendRedirect("/user");
    }
}
