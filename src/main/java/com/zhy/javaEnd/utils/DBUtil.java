package com.zhy.javaEnd.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Lenovo
 * @version 1.0
 * @description TODO
 * @date 7/6/2023 下午7:38
 */

public class DBUtil {
    private static String resource = "mybatis-config.xml";
    private static SqlSession sqlSession = null;
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSession getSqlSession() {
        sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }

}
