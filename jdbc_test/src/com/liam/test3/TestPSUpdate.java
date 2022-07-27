package com.liam.test3;

import com.liam.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Liam Li
 * @date 2021/12/30
 * @Description
 */
public class TestPSUpdate {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement st = null;

        try {
            con = JdbcUtils.getConnection();
            String sql = "update `users` set `NAME` = ? where `id` = ?";
            st = con.prepareStatement(sql);
            st.setInt(2,1);
            st.setString(1,"zs");

            int i = st.executeUpdate();
            if (i > 0) {
                System.out.println("更改成功!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(con,st,null);
        }

    }
}
