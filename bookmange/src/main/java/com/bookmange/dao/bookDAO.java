package com.bookmange.dao;

import com.bookmange.util.sqlMap;
import com.bookmange.dao.model.model1;
import com.bookmange.util.DB;
import com.bookmange.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class bookDAO implements model1<Book>{
    @Override
    public int getTotal() {
        int total = 0;
        try (Connection c = DB.getConnection(); Statement s = c.createStatement()) {

            String sql = "select count(*) from book";

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
//            System.out.println("total:" + total);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public void add(Book book) {
        String sql=sqlMap.add;
        try (Connection conn = DB.getConnection();PreparedStatement st = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);){
            st.setString(1,book.getBookName());
            st.setString(2,book.getAuthorName());
            st.setInt(3,book.getBookNumber());
            st.setString(4,book.getBooksType());
            st.setString(5,book.getBookConcern());
            st.setString(6,book.getLanguageType());
            st.setDouble(7, book.getMoney());
            st.setString(8, book.getRemark());
            st.execute();

            ResultSet rs=st.getGeneratedKeys();
            if(rs.next()) {
                int id = rs.getInt(1);
                book.setId(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean delete(int id) {
        String sql=sqlMap.deleteById + id;
        try(Connection conn=DB.getConnection();
            PreparedStatement st=conn.prepareStatement(sql);) {
            st.execute();            
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean delete(String book_name) {
        String sql=sqlMap.deleteByName + "'%"+book_name+"%'";
        try(Connection conn=DB.getConnection();
            PreparedStatement st=conn.prepareStatement(sql);){
            
            st.execute();
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Book get(int id){
        Book book=null;
        String sql=sqlMap.queryById + id;
        try (Connection conn=DB.getConnection();
            Statement st=conn.createStatement();){
            
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()) {
                book=new Book();
                book.setBookName(rs.getString("book_name"));
                book.setAuthorName(rs.getString("book_author"));
                book.setBookConcern(rs.getString("book_concern"));
                book.setBooksType(rs.getString("book_type"));
                book.setBookNumber(rs.getInt("book_number"));
                book.setLanguageType(rs.getString("language_type"));
                book.setMoney(rs.getDouble("book_price"));
                book.setRemark(rs.getString("remark"));
                book.setId(id);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> queryBook(String book_name) {
        String sql = sqlMap.queryByName + "'%"+book_name+"%'";
        List<Book> books=new ArrayList<>();
        Book book;
        try (Connection conn=DB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);){
            
            ResultSet rs=st.executeQuery();
            while(rs.next()) {
                book=new Book();
                book.setBookName(rs.getString("book_name"));
                book.setAuthorName(rs.getString("book_author"));
                book.setBookConcern(rs.getString("book_concern"));
                book.setBooksType(rs.getString("book_type"));
                book.setBookNumber(rs.getInt("book_number"));
                book.setLanguageType(rs.getString("language_type"));
                book.setMoney(rs.getDouble("book_price"));
                book.setRemark(rs.getString("remark"));
                book.setId(rs.getInt("id"));
                books.add(book);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return books;
    }
    
    
}
