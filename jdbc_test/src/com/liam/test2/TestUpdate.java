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
public class TestUpdate {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet res = null;

        try {
            con = JdbcUtils.getConnection();
            st = con.createStatement();
            String sql = "UPDATE users SET NAME = 'lisi' WHERE id = 1;";
            int i = st.executeUpdate(sql);
            if (i > 0) {
                System.out.println("更改成功！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
          JdbcUtils.release(con,st,res);
        }
    }
}
