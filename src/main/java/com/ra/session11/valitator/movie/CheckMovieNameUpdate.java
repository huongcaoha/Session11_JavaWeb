package com.ra.session11.valitator.movie;

import com.ra.session11.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
public class CheckMovieNameUpdate implements ConstraintValidator<CheckMovieUpdate, String> {
    @Autowired
    private MovieService movieService;
    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {

        return false;
    }
}
