package com.bookmange.dao;

import com.bookmange.util.sqlMap;
import com.bookmange.util.DB;

import java.sql.*;

import com.bookmange.dao.model.model2;
import com.bookmange.entity.user.*;


public class userDAO implements model2<User>{
    @Override
    public void update(String newPass) {
        String sql = sqlMap.updateUserPassword;
        try (Connection conn = DB.getConnection();PreparedStatement st = conn.prepareStatement(sql);){
            st.setString(1, newPass);
            st.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public User query() {
        User user1=null;
        String sql = sqlMap.queryUser;
        try (Connection conn = DB.getConnection();PreparedStatement st = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);){
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                user1 = new User();
                user1.setId(rs.getInt("id"));
                user1.setUserName(rs.getString("username"));
                user1.setPassword(rs.getString("password"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return user1;
    }

}
