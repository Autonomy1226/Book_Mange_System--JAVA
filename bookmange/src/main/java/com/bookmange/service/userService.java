package main.java.com.bookmange.service;

import main.java.com.bookmange.entity.user.User;
import main.java.com.bookmange.dao.userDAO;

import java.util.List;

public class userService {
    private static userDAO userdao = new userDAO();

    public static void update(User user) {
        userdao.update(user);
    }    
    public static User query() {
        return userdao.query();
    }
}
