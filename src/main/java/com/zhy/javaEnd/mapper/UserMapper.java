package com.zhy.javaEnd.mapper;
import com.zhy.javaEnd.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;


/**
 * @author Lenovo
 * @version 1.0
 * @description TODO
 * @date 30/5/2023 下午4:51
 */

public interface UserMapper  {

    User findUserById(int id);

    List<User> findAll();

    User findUserByLogin(@Param("username") String userName, @Param("password") String userPassword);

    User findUserByLoginMap(HashMap<String, Object> map);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(User user);
}