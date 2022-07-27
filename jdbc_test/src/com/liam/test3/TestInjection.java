package com.liam.test3;

import com.liam.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Liam Li
 * @date 2021/12/30
 * @Description
 */
public class TestInjection {
    public static void main(String[] args) {

//        String userName = "lisi";
//        String passWord = "123456";

        String userName = "' or '1 = 1";
        String passWord = "' or '1 = 1";
        logIn(userName,passWord);

    }

    public static void logIn(String userName,String passWord) {

        Connection conn = null;
        Statement st = null;
        ResultSet res = null;

        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "select * from users where `NAME` = '" + userName +"' and `PASSWORD` = '" + passWord + "';";
            res = st.executeQuery(sql);
            while (res.next()) {
                System.out.println(res.getString("name"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(conn,st,res);
        }
    }
}
