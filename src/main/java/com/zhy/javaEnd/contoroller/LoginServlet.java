package com.zhy.javaEnd.contoroller;

import com.zhy.javaEnd.model.User;
import com.zhy.javaEnd.service.UserService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
* @description TODO
* @author Lenovo
* @date 10/5/2023 上午10:42
* @version 1.0
*/
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String name = req.getParameter("name");
        String pwd = req.getParameter("password");
        String code = req.getParameter("code");

        UserService us = new UserService();
        User user = us.findUserByLogin(name, pwd);
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();

        String oldCode=(String)session.getAttribute("code");

        PrintWriter out = resp.getWriter();


//        System.out.println("code = " + code);
//        System.out.println("oldCode = " + oldCode);
//        if(user != null && user.getUserPassword().equals(pwd) && code.equals(oldCode)){
//            System.out.println("登录成功！！！");
//            // HttpSession session = req.getSession();
//            session.setAttribute("user",user);
//            resp.sendRedirect("/html/index.jsp");
//        }else {
//            System.out.println("登录失败");
//            req.setAttribute("msg","用户名或密码错误，请重新登录！");
//            req.getRequestDispatcher("/html/login.jsp").forward(req,resp);
//        }

        String msg = "";
        if ( !(user != null && user.getUserPassword().equals(pwd))) {
            msg += "用户名或密码错误";
        }
        if ( !(code.equals(oldCode))) {
            msg += "   验证码错误！";
        }
        if ("".equals(msg)) {
            System.out.println("登录成功！！！");
            session.setAttribute("user",user);
            resp.sendRedirect("/html/index.jsp");
        } else {
            System.out.println(msg);
            req.setAttribute("msg",msg);
            req.getRequestDispatcher("/html/login.jsp").forward(req,resp);
        }

        out.flush();
        out.close();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
