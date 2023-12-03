package main.java.com.bookmange.dao.model;

import java.util.List;

public interface model1<T> {
    //表数据的条数
    public int getTotal();
    //添加书
    public void add(T t);
    //获取
    public T get(int id);
    //删除书
    public boolean delete(int id);
    public boolean delete(String book_name);

    //查询书籍
    public List<T> queryBook(String book_name);

}
