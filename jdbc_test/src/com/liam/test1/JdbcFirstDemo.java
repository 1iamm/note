package com.liam.test1;

import java.sql.*;

/**
 * @author Liam Li
 * @date 2021/12/28
 * @Description
 */
public class JdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/jdbcStudy?useUnicode=true&characterEncoding=utf8&useSSL=true";

        String username = "root";
        String password = "123";

        //3.连接成功，返回数据库对象
        Connection connection = DriverManager.getConnection(url, username, password);

        //4.执行SQL的对象
        Statement statement = connection.createStatement();

        //5.执行SQL的对象去执行SQL可能存在结果，查看返回结果
        String sql = "SELECT * FROM users;";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("id = " + resultSet.getObject("id"));
            System.out.println("name = " + resultSet.getObject("NAME"));
            System.out.println("password = " + resultSet.getObject("PASSWORD"));
            System.out.println("email = " + resultSet.getObject("email"));
            System.out.println("birthday = " + resultSet.getObject("birthday"));
            System.out.println("");
        }

        //6.释放连接
        resultSet.close();
        statement.close();
        connection.close();

    }
}
