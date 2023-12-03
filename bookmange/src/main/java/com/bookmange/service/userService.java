package com.bookmange.service;

import com.bookmange.entity.user.User;
import com.bookmange.dao.userDAO;

import java.util.List;

public class userService {
    private static userDAO userdao = new userDAO();

    public static void update(String newPass) {
        userdao.update(newPass);
    }    
    public static User query() {
        return userdao.query();
    }
    public static String queryPass(int id) {
        return userdao.queryPass(id);
    }
}
