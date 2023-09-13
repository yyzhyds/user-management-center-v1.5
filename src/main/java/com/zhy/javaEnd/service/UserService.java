package com.zhy.javaEnd.service;

import com.zhy.javaEnd.mapper.UserMapper;
import com.zhy.javaEnd.model.User;
import com.zhy.javaEnd.utils.DBUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.util.List;



/**
* @description TODO
* @author Lenovo
* @date 7/6/2023 下午7:37
* @version 1.0
*/

public class UserService {
    SqlSession ss = DBUtil.getSqlSession();
    UserMapper mapper = ss.getMapper(UserMapper.class);


    public User findUserById(int id){
        return mapper.findUserById(id);
    }
    public List<User> findAll(){
        return mapper.findAll();
    }
    public int addUser(User user){
        return mapper.addUser(user);
    }
    public int deleteUser(User user){
        return mapper.deleteUser(user);
    }
    public int updateUser(User user){
        return mapper.updateUser(user);
    }
    public User findUserByLogin(@Param("username") String userName, @Param("password") String userPassword){
        return mapper.findUserByLogin(userName,userPassword);
    }
}
