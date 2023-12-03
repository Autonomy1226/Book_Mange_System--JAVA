package com.bookmange.gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class mainFrame extends JFrame{
    private Container c = this.getContentPane();//获取内容窗格
    private JMenuBar menuBar;
    private JMenu help;
    private JMenu author;

    public  mainFrame(){
        init();
        this.setTitle("图书管理系统 ");
        this.setSize(800,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void init(){
        this.addFoldableMenuBar();//加入菜单栏面板
        this.addContentPanel();//加入内容面板
        this.setJMenuBar(MenuBar());
    }
    public JMenuBar MenuBar(){
        menuBar = new JMenuBar();
        help = new JMenu("帮助");
        author=new JMenu("作者");

        JMenuItem author1 =new JMenuItem("侯兆龙");
        JMenuItem author2 =new JMenuItem("胡家树");
        JMenuItem author3 =new JMenuItem("罗贺文");
        JMenuItem author4 =new JMenuItem("张恒达");

        author.add(author1);
        author.add(author2);
        author.add(author3);
        author.add(author4);

        menuBar.add(help);
        menuBar.add(author);

        return menuBar;
    }
    //增加菜单栏
    public void addFoldableMenuBar(){
        c.add(FoldableMenuBar.getFoldableMenuBar(),BorderLayout.NORTH);
    } //增加内容面板
    public void addContentPanel(){
        String imagePath="D:\\develop\\BookManagerSystem\\target\\bg.jpg";
        initial_panel imagepanel =new initial_panel(imagePath);
        this.add(imagepanel, BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


}

