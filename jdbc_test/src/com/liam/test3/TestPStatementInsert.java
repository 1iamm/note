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
public class TestPStatementInsert {

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement st = null;

        try {
            con = JdbcUtils.getConnection();
            String sql = "insert into `users` values (?,?,?,?,?);";
            st = con.prepareStatement(sql);
            st.setInt(1,4);
            st.setString(2,"huluwa");
            st.setString(3,"123456");
            st.setString(4,"huluwa@sina.com");
            st.setDate(5,new Date(1999,1,26));

            int i = st.executeUpdate();
            if (i > 0) {
                System.out.println("插入成功!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(con,st,null);
        }

    }
}
