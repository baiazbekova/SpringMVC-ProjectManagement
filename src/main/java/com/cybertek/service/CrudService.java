package com.cybertek.service;

import java.util.List;

public interface CrudService <T,ID> {

   List<T> findAll();
   T findByID(ID id);

   T saveByID(ID id);
   void deleteByID(ID id);
   void delete(T object);

   T save (T object);

   void update (T object);
}
