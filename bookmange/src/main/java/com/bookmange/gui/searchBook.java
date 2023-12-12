package com.bookmange.gui;

import com.bookmange.service.bookService;
import com.bookmange.entity.Book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;


class searchBook extends JFrame {
    private JLabel label;
    private JTextField searchBox;
    private JButton search;
    private JTable table;
    final Object[] title = {"编号", "书籍名称", "书籍作者", "库存数", "书籍类型", "语种", "出版社", "定价", "备注"};
    private DefaultTableModel model;
    private List<Book> books = new ArrayList<>();

    public searchBook() {
        init();
        this.setVisible(true);
        this.setBounds(200, 150, 700, 500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("正在查询图书...");
    }

    private void init() {
        label=new JLabel("请输入书名：");
        searchBox = new JTextField(10);
        search = new JButton("搜索");

        // Creating table model with columns from the 'title' array
        model = new DefaultTableModel();
        model.setColumnIdentifiers(title);

        // Sample data (you might want to replace this with your actual data)
        Object[][] data = searchBook.this.dataInfo(bookService.queryBook(""));

        // Add data to the table model
        for (Object[] row : data) {
            model.addRow(row);
        }
        // Create table using the model
        table = new JTable(model);

        // Place the table in a scroll pane to view all data
        JScrollPane scrollPane = new JScrollPane(table);

        // Add components to the panel
        JPanel panel = new JPanel(null);
        
        //设置表格每个格高度
        table.setRowHeight (25);

        // 设置组件的位置和大小
        label.setBounds(10,10,90,30);
        searchBox.setBounds(90, 10, 150, 30);//10
        search.setBounds(250, 10, 80, 30);//170
        scrollPane.setBounds(10, 50, 660, 300);

        // 将组件添加到面板
        panel.add(label);
        panel.add(searchBox);
        panel.add(search);
        panel.add(scrollPane);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = searchBox.getText();
                model.setRowCount(0);
                Object[][] data = searchBook.this.dataInfo(bookService.queryBook(keyword));
                for(int i=0; i< data.length; ++i) {
                    model.addRow(data[i]);
                }
                searchBook.this.table.updateUI();
            }
        });

        // 将面板设置为内容面板
        this.setContentPane(panel);
    }
    private Object[][] dataInfo(List<Book> books) {//BookService.list()
        Object[][] data = new Object[10][9];
        this.books = books;
        for (int j = 0; j <= (books.size() / 10) && (books.size() % 10) != 0; j++) {
            for (int i = 0; i < 10; i++) {
                if((10*j+i)>=books.size()){
                    break;
                }
                Book book = books.get(i);
                data[i%9][0] = book.getId();
                data[i%9][1] = book.getBookName();
                data[i%9][2] = book.getAuthorName();
                data[i%9][3] = book.getBookNumber();
                data[i%9][4] = book.getBooksType();
                data[i%9][5] = book.getLanguageType();
                data[i%9][6] = book.getBookConcern();
                data[i%9][7] = book.getMoney();
                data[i%9][8] = book.getRemark();
            }
        }
        return data;
    }
}
