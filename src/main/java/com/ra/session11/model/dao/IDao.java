package com.ra.session11.model.dao;

import java.util.List;

public interface IDao<T,E> {
    List<T> findAll();
    void save(T object);
    void delete(E id);
    void update(T object);
    T findById(E id);
    boolean checkNameExisted(String name);
    boolean checkNameUpdate(String newName , String oldName);
}
