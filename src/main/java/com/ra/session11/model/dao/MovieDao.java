package com.ra.session11.model.dao;

import com.ra.session11.model.entity.Movie;
import com.ra.session11.model.entity.RowMapperMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieDao implements IDao<Movie,Long>{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> findAll() {
        String sql = "select * from movies";
        return jdbcTemplate.query(sql,new RowMapperMovie());
    }

    @Override
    public void save(Movie object) {
        String sql = "insert into movies(title,director,releaseDate,genre,poster) values(?,?,?,?,?)";
        jdbcTemplate.update(sql,object.getTitle(),object.getDirector(),object.getReleaseDate(),object.getGenre(),object.getPoster());
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from movies where id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void update(Movie object) {
        String sql = "update movies set title=?,director=?,releaseDate=?,genre = ?,poster=? where id=?";
        jdbcTemplate.update(sql,object.getTitle(),object.getDirector(),object.getReleaseDate(),object.getGenre(),object.getPoster(),object.getId());
    }

    @Override
    public Movie findById(Long id) {
        String sql = "select * from movies where id=?";
       try {
           return jdbcTemplate.queryForObject(sql,new RowMapperMovie(),id);
       } catch (Exception e) {
           return null;
       }
    }

    @Override
    public boolean checkNameExisted(String name) {
        String sql = "select * from movies where title=?";
       try {
           Movie movie = jdbcTemplate.queryForObject(sql,new RowMapperMovie(),name);
           return movie != null;
       }catch (Exception e) {
           return false;
       }
    }

    @Override
    public boolean checkNameUpdate(String newName , String oldName) {
        String sql = "select * from movies where title=? and title != ?";
        try {
            Movie movie = jdbcTemplate.queryForObject(sql,new RowMapperMovie(),newName,oldName);
            return movie != null;
        } catch (Exception e) {
           return false;
        }
    }

}
