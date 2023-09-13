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
* @date 7/6/2023 上午8:20
* @version 1.0
*/
@WebServlet("/deleteUser")
public class DeleteServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        UserService us = new UserService();
        User user = us.findUserById(Integer.parseInt(id));
        int i = us.deleteUser(user);
        if(i>0){
            //sqlSession.commit();
            System.out.println("成功");

        }else {
            System.out.println("失败");
        }
        resp.sendRedirect("/user");
    }
}
