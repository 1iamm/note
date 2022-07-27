package com.liam.test3;

import com.liam.utils.JdbcUtils;

import java.sql.*;

/**
 * @author Liam Li
 * @date 2021/12/30
 * @Description
 */
public class TestPSQuery {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet res = null;
        try {
            con = JdbcUtils.getConnection();
            String sql = "select * from `users` where `NAME` = ? and `PASSWORD` = ?";
            st = con.prepareStatement(sql);
            st.setString(1,"lisi");
            st.setString(2,"123456");

            res = st.executeQuery();
            if (res.next()) {
                System.out.println(res.getInt("ID"));
                System.out.println(res.getString("NAME"));
                System.out.println(res.getString("PASSWORD"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(con,st,null);
        }
    }
}
