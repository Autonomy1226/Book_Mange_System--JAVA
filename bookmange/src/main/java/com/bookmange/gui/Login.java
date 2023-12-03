package com.bookmange.gui;

import com.bookmange.util.*;
import com.bookmange.entity.user.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Login extends JFrame{
    private JTextField username;
    private JTextField password;
    private JButton login;
    private JButton reset;
    private Container c;
    public Login() {
        init();
        this.setLayout(null);
        this.setBounds(500,250,500,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("登录");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    private void init()
    {
        c = this.getContentPane();
        c.setLayout(null);

        JLabel user = new JLabel("用户名：");
        user.setBounds(60,50,70,30);
        username = new JTextField(20);
        username.setBounds(120,50,200,30);
        JLabel code = new JLabel("密码：");
        code.setBounds(60,90,70,30);
        password = new JPasswordField(20);
        password.setBounds(120,90,200,30);
        reset = new JButton("重置");
        reset.setBounds(100,130,70,30);
        login = new JButton("登录");
        login.setBounds(240,130,70,30);
        c.add(user);
        c.add(username);
        c.add(code);
        c.add(password);
        c.add(reset);
        c.add(login);
        this.setSize(320,150);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username1 = username.getText();
                String password1 = password.getText();
                if(PanelUtil.getThisUser(username1, password1)) {
                    JOptionPane.showMessageDialog(null, "登录成功！");
                    new mainFrame();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null ,"账号或密码错误", "错误",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        );
    }
    }
