package com.bookmange.util;

import com.bookmange.dao.userDAO;
import com.bookmange.entity.Book;
import com.bookmange.entity.user.*;
import com.bookmange.service.*;
import java.util.List;

import javax.swing.*;
import java.awt.*;

public class PanelUtil {
    //判断用户名密码是否正确


    /**
     * 设置窗口居中显示
     * @param window 要被居中的窗口
     */
    public static void SetCenter(Window window){
        //定义一个工具包
        Toolkit kit = Toolkit.getDefaultToolkit();
        //得到屏幕的大小
        Dimension screenSize = kit.getScreenSize();
        //得到屏幕的宽和高
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        //获得当前的窗口的宽和高
        int windowWidth = window.getWidth();
        int windowHeight = window.getHeight();

        //设置窗口的位置，使它居中
        window.setLocation((screenWidth-windowWidth)/2 , (screenHeight-windowHeight)/2);
    }

    //判断输入内容是否为空
    public static boolean isNull(JTextField input){
        return input.getText().equals("");
    }

    /**
     * 通过数据库来验证输入的用户信息
     * @param userName 需要验证的用户名
     * @param password 需要验证的密码
     * @return 这个用户的信息类，如果不匹配 返回值为空
     */
    public static boolean getThisUser(String userName,String password){
        User user1 = new User();
        user1=userService.query();
        String rightPass=user1.getPassword();
        String rightName=user1.getUserName();
        if (userName.equals(rightName)&&password.equals(rightPass)){
            return true;
        }
        
        return false;
    }

    /**
     * 判断该用户名是否重名
     * @param userName 该用户名
     * @return 重名返回true 否则为false
     */
    public static boolean isSamePassword(String userP){
        String old = userService.query().getPassword();
        if (old.equals(userP)){
            return false;
        }
        return true;
    }
}