package com.bookmange.gui;

import com.bookmange.service.userService;
import com.bookmange.util.PanelUtil;
import com.bookmange.entity.user.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changePassward extends JFrame {
    private JTextField oldPassward;
    private JTextField newPassward;
    private JButton reset;
    private JButton set;
    public changePassward()
    {
        init();
        this.setTitle("修改密码");
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(500,200,450,400);
    }
    private void init()
    {
        oldPassward =new JTextField(10);
        newPassward =new JTextField(10);
        reset =new JButton("重置");
        set =new JButton("设置");
        this.add(new JLabel("请输入旧密码"));
        this.add(oldPassward);
        this.add(new JLabel("请输入新密码"));
        this.add(newPassward);
        this.add(reset);
        this.add(set);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oldPassward.setText("");
                newPassward.setText("");
                
            }
        });
        set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldPass=oldPassward.getText();
                String newPass=newPassward.getText();
                String check=userService.queryPass(1);
                
                if(oldPass.equals("") || newPass.equals("")) {
                    JOptionPane.showMessageDialog(null, "密码不能为空","错误",JOptionPane.ERROR_MESSAGE);
                } else if(!oldPass.equals(check)) {
                    JOptionPane.showMessageDialog(null, "旧密码错误","错误",JOptionPane.ERROR_MESSAGE);
                    reset.doClick();
                    return;
                } else if(newPass.length()>=32) {
                    JOptionPane.showMessageDialog(null, "密码长度不能大于32位");
                    reset.doClick();
                    return;
                } else if(newPass.equals(oldPass)) {
                    JOptionPane.showMessageDialog(null, "新密码不能与旧密码相同");
                    reset.doClick();
                    return;
                }

                userService.update(newPass);
                JOptionPane.showMessageDialog(null, "修改成功","成功",JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}

