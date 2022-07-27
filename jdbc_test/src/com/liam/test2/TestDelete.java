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
public class TestDelete {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet res = null;

        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "DELETE FROM users WHERE id = 4;";
            int i = st.executeUpdate(sql);
            if (i > 0) {
                System.out.println("删除成功!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, res);
        }


    }

}
