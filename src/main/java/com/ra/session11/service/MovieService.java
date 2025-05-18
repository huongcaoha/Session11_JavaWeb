package com.ra.session11.service;

import com.ra.session11.model.dao.MovieDao;
import com.ra.session11.model.entity.Movie;
import com.ra.session11.model.entity.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IService<Movie,Long>{
    @Autowired
    private MovieDao movieDao;
    @Override
    public List<Movie> findAll() {
        return movieDao.findAll();
    }

    @Override
    public void save(Movie object) {
        movieDao.save(object);
    }

    @Override
    public void delete(Long id) {
        movieDao.delete(id);
    }

    @Override
    public void update(Movie object) {
        movieDao.update(object);
    }

    @Override
    public Movie findById(Long id) {
        return movieDao.findById(id);
    }

    @Override
    public boolean checkNameExisted(String name) {
        return movieDao.checkNameExisted(name);
    }

    @Override
    public boolean checkNameUpdate(String newName, String oldName) {
        return movieDao.checkNameUpdate(newName, oldName);
    }


}
