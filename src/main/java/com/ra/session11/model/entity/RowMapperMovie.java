package com.ra.session11.model.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperMovie implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Movie movie = new Movie();
        movie.setId(rs.getLong("id"));
        movie.setTitle(rs.getString("title"));
        movie.setDirector(rs.getString("director"));
        movie.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
        movie.setGenre(rs.getString("genre"));
        movie.setPoster(rs.getString("poster"));
        return movie;
    }
}
