package main.java.com.bookmange.util;

import javax.swing.*;

public class StyleUtil {
    private StyleUtil(){}
    public static void buttonStyle(JButton... buttons){
        //是按钮变为透明
        for (JButton button:buttons) {
            button.setContentAreaFilled(false);
        }
    }

}
