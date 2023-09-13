package com.zhy.javaEnd.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

/**
* @description TODO
* @author Lenovo
* @date 31/5/2023 下午9:15
* @version 1.0
*/

public class MyDruidDataSourceFactory extends PooledDataSourceFactory {
    //构造方法
    public MyDruidDataSourceFactory(){
        //  创建阿里巴巴连接池
        this.dataSource = new DruidDataSource();
    }
}
