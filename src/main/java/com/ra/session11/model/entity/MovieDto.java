package com.ra.session11.model.entity;

import com.ra.session11.valitator.movie.CheckMovieExisted;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieDto {

    private Long id;
    @NotBlank(message = "Can not Blank")
    @Size(max = 100)
    @CheckMovieExisted
    private String title;

    @NotBlank(message = "Can not Blank")
    @Size(max = 50)
    private String director;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Can not null")
    private LocalDate releaseDate;

    @NotBlank(message = "Can not Blank")
    @Size(max = 30)
    private String genre;

    @NotNull
    private MultipartFile poster;

}
