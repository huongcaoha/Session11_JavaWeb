package com.ra.session11.model.entity;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie {


    private Long id;
    @NotBlank
    @Size(max = 100)
    private String title;

    @NotBlank
    @Size(max = 50)
    private String director;

    private LocalDate releaseDate;

    @NotBlank
    @Size(max = 30)
    private String genre;

    @NotBlank
    private String poster;


}