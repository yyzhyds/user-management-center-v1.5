package com.zhy.javaEnd.contoroller;


import com.zhy.javaEnd.model.User;
import com.zhy.javaEnd.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUser")
public class AddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String pwd = req.getParameter("password");
        String phone = req.getParameter("s_phone");
        String email = req.getParameter("s_email");
        /*String resource = "mybatis-config.xml";
        SqlSession sqlSession = null;
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
*/

        User user = new User(null,name, pwd, phone, email);
        UserService us = new UserService();
        int i = us.addUser(user);
        if (i > 0){
            System.out.println(user);
            System.out.println("成功");
            //sqlSession.commit();
            resp.sendRedirect("/user");
        }else {
            System.out.println("失败");
            req.setAttribute("msg","添加用户失败");
            req.getRequestDispatcher("/html/add.jsp").forward(req,resp);

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
    //    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String pwd = req.getParameter("password");
//        String phone = req.getParameter("s_phone");
//        String email = req.getParameter("s_email");
//
//        System.out.println("name = " + name);
//        System.out.println("pwd = " + pwd);
//        System.out.println("phone = " + phone);
//        System.out.println("email = " + email);
//    }


}
