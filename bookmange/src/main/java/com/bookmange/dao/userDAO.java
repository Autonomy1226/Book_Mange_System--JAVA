package main.java.com.bookmange.dao;

import java.sql.*;

import main.java.com.bookmange.dao.model.model2;
import main.java.com.bookmange.entity.user.*;
import main.java.com.bookmange.util.sqlMap;
import main.java.com.bookmange.util.DB;

public class userDAO implements model2<User>{
    @Override
    public void update(User user) {
        try {
            String sql = sqlMap.updateUserPassword;
            Connection conn = DB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            st.setString(1, user.getPassword());
            st.execute(sql);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public User query() {
        User user1=null;
        String sql = sqlMap.queryUser;
        try {
            Connection conn = DB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
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
