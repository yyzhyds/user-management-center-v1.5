package com.zhy.javaEnd.contoroller;

import com.zhy.javaEnd.model.User;
import com.zhy.javaEnd.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Lenovo
 * @version 1.0
 * @description TODO
 * @date 17/5/2023 下午8:00
 */

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        String id = req.getParameter("id");
        if (null != id) {
            User user = userService.findUserById(Integer.parseInt(id));
            req.setAttribute("user", user);
            req.getRequestDispatcher("html/edit.jsp").forward(req, resp);
        } else {
            List<User> users = userService.findAll();
            req.setAttribute("list", users);
            req.getRequestDispatcher("/html/show.jsp").forward(req, resp);
        }

        //String resource = "mybatis-config.xml";
        // SqlSession sqlSession = null;
        // InputStream inputStream = Resources.getResourceAsStream(resource);
        // 不用背，知道有这一步，下一次直接复制
        // SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获得SqlSession
        //sqlSession = sqlSessionFactory.openSession();
        //UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 调用方法干活
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
