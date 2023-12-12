package com.bookmange.gui;

import com.bookmange.service.bookService;
import com.bookmange.entity.Book;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//图书名称 图书类型 书集系列名 分卷编号 编著者 语种 选择出版社 本次录入本数 书籍定价 备注 保存 重置
public class addBook extends JFrame{
    private JTextField bookName;
    private JTextField bookTypeBox;
    private JComboBox<String> bookType;
    private JTextField booksNameValue;
    private JTextField bookNumber;
    private JTextField author;
    private JTextField languageTypeBox;
    private JComboBox<String> languageType;
    private JTextField Concern;
    private JComboBox<String> bookConcern;
    private JTextField sum;
    private JTextField money;
    private JTextArea remark;
    private JButton save;
    private JButton reset;
    public addBook(){
        init();
        setVisible(true);
        setSize(800,600);
    }
    private void init()
    {
        this.setLayout(null);

        JLabel name = new JLabel("图书名称：");
        name.setBounds(30,20,70,25);
        bookName = new JTextField();
        bookName.setBounds(100,20,170,25);

        JLabel typeName = new JLabel("图书类型：");
        typeName.setBounds(300,20,70,25);
        String [] types = {" ","计算机科学","人文自然","旅游地理","各国语言"};
        bookType = new JComboBox<>(types);
        bookType.setBounds(370,20,100,25);
        bookTypeBox=new JTextField();
        bookTypeBox.setBounds(470,20,70,25);

        JLabel booksName = new JLabel("书集系列名：");
        booksName.setBounds(30,60,90,25);
        booksNameValue = new JTextField();
        booksNameValue.setBounds(120,60,420,25);

        JLabel bookNumberLb = new JLabel("分卷编号：");
        bookNumberLb.setBounds(30,100,70,25);
        bookNumber=new JTextField();
        bookNumber.setBounds(95,100,100,25);

        JLabel authorLabel = new JLabel("编著者：");
        authorLabel.setBounds(200,100,70,25);
        author =new JTextField();
        author.setBounds(250,100,190,25);

        JLabel language = new JLabel("语种：");
        language.setBounds(450,100,70,25);
        String []lts = {" ","中文","英语","阿拉伯语","法语","俄语","..."};
        languageType = new JComboBox<>(lts);
        languageType.setBounds(490,100,90,25);
        languageTypeBox=new JTextField();
        languageTypeBox.setBounds(580,100,65,25);

        JLabel bookConcernLab = new JLabel("选择出版社：");
        bookConcernLab.setBounds(30,140,90,25);
        String[] temp = {" ","清华大学出版社","北京大学出版社","吉林大学出版社","商务出版社","..."};
        bookConcern = new JComboBox<>(temp);
        bookConcern.setBounds(120,140,120,25);
        Concern=new JTextField();
        Concern.setBounds(240,140,110,25);

        JLabel sumLab = new JLabel("本次录入本数：");
        sumLab.setBounds(360,140,90,25);
        sum=new JTextField();
        sum.setBounds(450,140,80,25);

        JLabel moneyLab = new JLabel("书籍定价:");
        moneyLab.setBounds(30,180,80,25);
        money=new JTextField();
        money.setBounds(100,180,80,25);
        JLabel yuan = new JLabel("元");
        yuan.setBounds(180,180,20,25);

        JLabel remarkLab = new JLabel("备注");
        remarkLab.setBounds(240,180,50,25);
        remark=new JTextArea();
        remark.setLineWrap(true);
        remark.setBounds(240,220,300,125);

        save = new JButton("保存");
        save.setBounds(30,310,80,30);
        reset = new JButton("重置");
        reset.setBounds(120,310,80,30);
        this.add(name);
        this.add(bookName);
        this.add(typeName);
        this.add(bookType);
        this.add(bookTypeBox);
        this.add(booksName);
        this.add(booksNameValue);
        this.add(bookNumberLb);
        this.add(bookNumber);
        this.add(authorLabel);
        this.add(author);
        this.add(language);
        this.add(languageType);
        this.add(languageTypeBox);
        this.add(sumLab);
        this.add(sum);
        this.add(bookConcernLab);
        this.add(bookConcern);
        this.add(Concern);
        this.add(moneyLab);
        this.add(money);
        this.add(yuan);
        this.add(remarkLab);
        this.add(remark);
        this.add(save);
        this.add(reset);
        //addListener();
        //addListener();
        this.setBounds(300,200,650,450);
        this.setTitle("正在添加图书...");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(bookName.getText().equals("")||typeName.getText().equals("")||booksName.getText().equals("")||bookNumber.getText().equals("")||author.getText().equals("")||language.getText().equals("")||sum.getText().equals("")||Concern.getText().equals("")||money.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"请将信息填写完整！","错误",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    Book book = new Book();
                    book.setId(Integer.parseInt(bookNumber.getText()));
                    book.setBookName(bookName.getText());
                    book.setBooksType(bookTypeBox.getText());
                    book.setAuthorName(author.getText());
                    book.setLanguageType(languageTypeBox.getText());
                    book.setBookConcern(Concern.getText());
                    book.setBookNumber(Integer.parseInt(sum.getText()));
                    book.setMoney(Double.parseDouble(money.getText()));
                    book.setRemark(remark.getText());
                    bookService.add(book);
                    JOptionPane.showMessageDialog(null,"添加成功！","成功",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    });
    reset.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            bookNumber.setText("");
            booksNameValue.setText("");
            bookName.setText("");
            bookTypeBox.setText("");
            languageTypeBox.setText("");
            author.setText("");
            Concern.setText("");
            sum.setText("");
            money.setText("");
            remark.setText("");
        }
    });
    bookConcern.addActionListener(comboBoxAction);
    bookType.addActionListener(comboBoxAction);
    languageType.addActionListener(comboBoxAction);
    }
    ActionListener comboBoxAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==bookConcern){
                Concern.setText((String)bookConcern.getSelectedItem());
            }
            if (e.getSource()==languageType){
                languageTypeBox.setText((String)languageType.getSelectedItem());
            }
            if (e.getSource()==bookType){
                bookTypeBox.setText((String)bookType.getSelectedItem());
            }
        }
    };
}
