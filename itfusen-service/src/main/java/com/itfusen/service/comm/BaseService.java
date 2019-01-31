package com.itfusen.service.comm;


import java.util.List;

public interface BaseService<E>{

      List<E> queryByField(E object);

      List<E> queryAll();

      E queryById(Long id);
      int insert(E object);
      int update(E object);
      int delete(Long id);
}
