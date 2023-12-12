package com.bookmange.gui;

import com.bookmange.service.bookService;
import com.bookmange.entity.Book;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
public class deleteBook extends JFrame {
    private JTextField bookName;
    private JTextField bookNumber;
    private JButton delete;
    private JButton reset;
    
    private JTable table;
    final Object[] title = {"编号", "书籍名称", "书籍作者", "库存数", "书籍类型", "语种", "出版社", "定价", "备注"};
    private DefaultTableModel model;
    private List<Book> books = new ArrayList<>();
    
    public deleteBook()
    {
        init();
        this.setVisible(true);
        this.setBounds(200,200,750,550);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.setLayout(new FlowLayout());
        this.setTitle("正在删除图书...");
    }
    private void init()
    {
        bookName =new JTextField(7);
        bookNumber=new JTextField(4);
        delete=new JButton("删除");
        reset=new JButton("重置");
        //添加空白组件
        JLabel emptyLabel = new JLabel();
        emptyLabel.setPreferredSize(new Dimension(200, 80));
        
        // Creating table model with columns from the 'title' array
        model = new DefaultTableModel();
        model.setColumnIdentifiers(title);
        
        // Sample data (you might want to replace this with your actual data)
        Object[][] data = deleteBook.this.dataInfo(bookService.queryBook(""));
        
        // Add data to the table model
        for (Object[] row : data) {
            model.addRow(row);
        }
        // Create table using the model
        table = new JTable(model);
        
        // Place the table in a scroll pane to view all data
        JScrollPane scrollPane = new JScrollPane(table);
        
        //设置表格每个格高度
        table.setRowHeight (30);
        table.setPreferredScrollableViewportSize(new Dimension(700, 300));
        scrollPane.setBounds(10, 50, 700, 300);
        
        // 添加组件
        this.add(new JLabel("(请输入书名或分卷编号)"));
        this.add(new JLabel("书名:"));
        this.add(bookName);
        this.add(new JLabel("分卷编号:"));
        this.add(bookNumber);
        this.add(delete);
        this.add(reset);
        this.add(emptyLabel);
        this.add(scrollPane);
        
        
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String bookname=bookName.getText();
                String id=bookNumber.getText();
                List<Book> books=new ArrayList<>();
                books=bookService.queryBook(bookname);
                
                if(bookname.equals("")&&id=="")
                {
                    JOptionPane.showMessageDialog(null,"请输入书名或分卷编号");
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
                    if(!bookname.isEmpty())
                    {
                        if(!bookService.delete(bookname))
                        {
                            JOptionPane.showMessageDialog(null, "没有此书","失败",JOptionPane.QUESTION_MESSAGE);
                            return;
                        }
                    }
                    else if (!id.isEmpty())
                    {
                        if(!bookService.delete(Integer.parseInt(id)))
                        {
                            JOptionPane.showMessageDialog(null, "没有此书","失败",JOptionPane.QUESTION_MESSAGE);
                            return;
                        }
                    }
                    //删除图书
                    JOptionPane.showMessageDialog(null,"删除成功");
                    //刷新图书表
                    String keyword = "";
                    model.setRowCount(0);
                    Object[][] data = deleteBook.this.dataInfo(bookService.queryBook(keyword));
                    for(int i=0; i< data.length; ++i) {
                        model.addRow(data[i]);
                    }
                    deleteBook.this.table.updateUI();
                }
            }
        });
        
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookName.setText("");
                bookNumber.setText("");
            }
        });
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
