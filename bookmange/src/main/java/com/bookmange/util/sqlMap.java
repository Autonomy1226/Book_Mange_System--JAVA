package main.java.com.bookmange.util;

public class sqlMap {
    public static String add = "insert into user values (book_name,book_author,book_number,book_type,book_concern,language_type,book_price,remark)"+"values(?,?,?,?,?,?,?,?)";
    public static String deleteById = "delete from book where id = ";
    public static String deleteByName = "delete from book where book_name like ";
    public static String queryById = "select * from book where id = ";
    public static String queryByName = "select * from book where book_name like ";

    public static String queryUser = "select * from user where id = 1";
    public static String updateUserPassword = "update user set password = ? where id = 1";
}
