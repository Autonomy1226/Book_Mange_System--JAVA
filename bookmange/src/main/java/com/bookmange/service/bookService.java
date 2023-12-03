package com.bookmange.service;

import com.bookmange.entity.Book;
import com.bookmange.dao.bookDAO;

import java.util.ArrayList;
import java.util.List;

public class bookService {
    private final static bookDAO dao = new bookDAO();
    public static int getTotal(){
        return dao.getTotal();
    }

    //增加
    public static void add(Book book){
        dao.add(book);
    }

    //删除
    public static boolean delete(int id){
        return dao.delete(id);
    }
    public static boolean delete(String book_name){
        return dao.delete(book_name);
    }

    //获取
    public static Book get(int id){
        return dao.get(id);
    }

    public static List<Book> queryBook(String Query){
        List<Book> temp = new ArrayList<>();
        temp.addAll(dao.queryBook(Query));
        List<Book> books = new ArrayList<>();
        for (Book book : temp){
            if(!books.contains(book)){
                books.add(book);
            }
        }
        return books;
    }
}
