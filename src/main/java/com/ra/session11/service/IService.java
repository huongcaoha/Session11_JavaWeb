package com.ra.session11.service;

import java.util.List;

public interface IService<T,E>{
    List<T> findAll();
    void save(T object);
    void delete(E id);
    void update(T object);
    T findById(E id);
    boolean checkNameExisted(String name);
    boolean checkNameUpdate(String newName , String oldName);
}
