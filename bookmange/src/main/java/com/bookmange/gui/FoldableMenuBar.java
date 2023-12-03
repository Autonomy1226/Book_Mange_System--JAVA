package com.bookmange.gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;


public class FoldableMenuBar extends JPanel {
    JButton addBook;
    JButton chagePassward;
    JButton deleteBook;
    JButton searchBook;

    private static FoldableMenuBar foldableMenuBar = new FoldableMenuBar();
    public static FoldableMenuBar getFoldableMenuBar(){
        return foldableMenuBar;
    }
    public FoldableMenuBar(){
        init();
        this.setVisible(true);
        this.setBounds(100,200,800,100);
    }
    private void init() {
        addBook = new JButton("添加图书");
        deleteBook = new JButton("删除图书");
        searchBook = new JButton("查询图书");
        chagePassward = new JButton("修改密码");

        this.add(new JLabel("功能: "));
        this.add(addBook);
        this.add(deleteBook);
        this.add(searchBook);
        this.add(chagePassward);
        ActionListener addBooksListener = new AddBooksListener();
        ActionListener DeleteBooksListener = new DeleteBooksListener();
        addBook.addActionListener(addBooksListener);
        deleteBook.addActionListener(DeleteBooksListener);
        ActionListener searchBooksListener=new searchBooksListener();
        searchBook.addActionListener(searchBooksListener);
        ActionListener changePassward =new chagePasswardListener();
        chagePassward.addActionListener(changePassward);
    }

}
class AddBooksListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e) {
        addBook ab=new addBook();
    }
}
class DeleteBooksListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e) {
        deleteBook db=new deleteBook();
    }
}
class searchBooksListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e) {
        searchBook sb=new searchBook();
    }
}
class chagePasswardListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        changePassward cp =new changePassward();
    }
}