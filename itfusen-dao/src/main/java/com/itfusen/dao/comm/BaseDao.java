package com.itfusen.dao.comm;


import java.util.List;

public interface BaseDao<T> {

    List<T> queryByField(T object);
    T queryById(String id);
    T queryByLongId(Long id);

    List<T> queryAll();

    int insert(T object);

    int update(T object);

    int delete(Long id);

}
