package com.bookmange.gui;

import com.bookmange.service.bookService;
import com.bookmange.entity.Book;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
public class deleteBook extends JFrame {
    private JTextField bookName;
    private JTextField authorName;
    private JTextField bookNumber;
    private JButton delete;
    private JButton reset;
    public deleteBook()
    {
        init();
        this.setBounds(200,200,500,500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.setTitle("正在删除图书...");
    }
    private void init()
    {
        bookName =new JTextField(7);
        authorName=new JTextField(4);
        delete=new JButton("删除");
        reset=new JButton("重置");
        bookNumber=new JTextField(4);
        this.add(new JLabel("书名:"));
        this.add(bookName);
        this.add(new JLabel("作者:"));
        this.add(authorName);
        this.add(new JLabel("分卷编号:"));
        this.add(bookNumber);
        this.add(delete);
        this.add(reset);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String bookname=bookName.getText();
                String authorname=authorName.getText();
                String id=bookNumber.getText();
                List<Book> books=new ArrayList<>();
                books=bookService.queryBook(bookname);
                
                if(bookname.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"请输入书名");
                }
                else if(authorname=="")
                {
                    JOptionPane.showMessageDialog(null,"请输入作者");
                }
                else if(id=="")
                {
                    JOptionPane.showMessageDialog(null,"请输入分卷编号");
                }
                else
                {
                    if(books.size()==0) {
                        JOptionPane.showMessageDialog(null, "没有此书","失败",JOptionPane.QUESTION_MESSAGE);
                        return;
                    }
                    bookService.delete(bookname);
                    //删除图书
                    JOptionPane.showMessageDialog(null,"删除成功");
                }
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookName.setText("");
                authorName.setText("");
                bookNumber.setText("");
            }
        });
    }

}
