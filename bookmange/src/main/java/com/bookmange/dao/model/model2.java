package main.java.com.bookmange.dao.model;

public interface model2<T> {
    //修改用户密码
    public void update(T t);
    
    //查询用户
    public T query();
}
