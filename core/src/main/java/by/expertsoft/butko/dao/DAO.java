package by.expertsoft.butko.dao;

import java.util.List;

/**
 * Created by wladek on 09.08.16.
 */
public interface DAO<T> {
    void insert(T t);
    T getById(Integer id);
    void remove(T t);
    List<T> getList();
    void update(T t);

}
