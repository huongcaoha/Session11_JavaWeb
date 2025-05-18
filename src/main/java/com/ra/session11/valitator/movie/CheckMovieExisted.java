package com.ra.session11.valitator.movie;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CheckMovieNameExisted.class)
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckMovieExisted {
    String message() default "Movie name existed !";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
