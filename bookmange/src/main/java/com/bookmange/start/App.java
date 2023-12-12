package com.bookmange.start;

import com.bookmange.gui.Login;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            new Login();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
