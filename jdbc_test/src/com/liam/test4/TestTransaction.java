package com.liam.test4;

import com.liam.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Liam Li
 * @date 2021/12/31
 * @Description
 */
public class TestTransaction {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = JdbcUtils.getConnection();
//            关闭自动提交，开启事务
            conn.setAutoCommit(false);

            String sql1 = "update account set money = money + 100 where name = 'A'";
            st = conn.prepareStatement(sql1);
            st.executeUpdate();

            String sql2 = "update account set money = money - 100 where name = 'B'";
            st = conn.prepareStatement(sql2);
            st.executeUpdate();
//            事务提交
            conn.commit();
            System.out.println("执行成功！");
        } catch (SQLException throwables) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
          JdbcUtils.release(conn,st,null);
        }
    }
}
