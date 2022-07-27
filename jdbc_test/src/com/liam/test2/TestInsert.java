package com.liam.test2;

import com.liam.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Liam Li
 * @date 2021/12/29
 * @Description
 */
public class TestInsert {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //获取数据库连接
            connection = JdbcUtils.getConnection();
//          获得SQL的执行对象
            statement = connection.createStatement();
//          SQL命令
            String sql = "INSERT INTO users VALUES(4,'hulu','123456','hulu@sina.com','1999-01-08')";
//            执行sql
            int i = statement.executeUpdate(sql);
            if (i > 0) {
                System.out.println("插入成功!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(connection,statement,resultSet);
        }


    }
}
