package com.ra.session11.controller;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;


import com.ra.session11.model.entity.Movie;
import com.ra.session11.model.entity.MovieDto;
import com.ra.session11.model.entity.MovieDtoUpdate;
import com.ra.session11.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping
    public String listMovies(Model model) {
        List<Movie> movies = movieService.findAll();
        model.addAttribute("movies", movies);
        return "listMovie";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("movieDto", new MovieDto());
        return "add";
    }

    @PostMapping("/add")
    public String addMovie(@Valid @ModelAttribute("movieDto") MovieDto movieDto,
                           BindingResult result, RedirectAttributes redirectAttributes) throws IOException {
        if(movieDto.getPoster() == null || movieDto.getPoster().isEmpty()) {
            result.rejectValue("poster", "error.poster", "You must provide a valid poster.");
        }
        // Kiểm tra lỗi từ BindingResult
        if (result.hasErrors()) {
            return "add"; // Quay lại trang nếu có lỗi
        }

        String UPLOAD_DIR = "C:/Users/Admin/IdeaProjects/demo3/Session11/src/main/webapp/uploads";
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs(); // Tạo thư mục nếu chưa tồn tại
        }

        Movie movie = convertMovieDtoToMovie(movieDto);

        // upload lên server
//        File fileUpload = new File(uploadDir, movieDto.getPoster().getOriginalFilename());
//        movieDto.getPoster().transferTo(fileUpload);
//        movie.setPoster("/uploads/" + movieDto.getPoster().getOriginalFilename());
            Map<String,Object> uploadResult = cloudinary.uploader().upload(movieDto.getPoster().getBytes(),ObjectUtils.emptyMap());
            movie.setPoster(uploadResult.get("url").toString());

        movieService.save(movie);
        redirectAttributes.addFlashAttribute("message", "Movie added successfully.");
        return "redirect:/movies"; // Chuyển hướng về danh sách phim
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model ) {
        Movie movie = movieService.findById(id);
        MovieDtoUpdate movieDtoUpdate = convertMovieToMovieDtoUpdate(movie);
        model.addAttribute("movieDtoUpdate", movieDtoUpdate);
        model.addAttribute("image",movie.getPoster());
        return "update";
    }

    @PostMapping("/edit")
    public String editMovie(@Valid @ModelAttribute MovieDtoUpdate movieDtoUpdate, BindingResult result,Model model,RedirectAttributes redirectAttributes) throws IOException {
        Movie oldMovie = movieService.findById(movieDtoUpdate.getId());
        Movie movie = convertMovieDtoUpdateToMovie(movieDtoUpdate);
        boolean checkNameExist = movieService.checkNameUpdate(movieDtoUpdate.getTitle(),oldMovie.getTitle());
        if (checkNameExist) {
            result.rejectValue("title", "error.title", "Title already exist.");
        }
        if (result.hasErrors()) {
            model.addAttribute("movieDtoUpdate", movieDtoUpdate);
            return "update";
        }

        if (!movieDtoUpdate.getPoster().isEmpty()) {
            Map<String,Object> uploadResult = cloudinary.uploader().upload(movieDtoUpdate.getPoster().getBytes(), ObjectUtils.emptyMap());
            movie.setPoster(uploadResult.get("url").toString());
        }else {
            movie.setPoster(oldMovie.getPoster());
        }

        movieService.update(movie);
        redirectAttributes.addFlashAttribute("message", "Movie updated successfully.");
        return "redirect:/movies";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable long id , RedirectAttributes redirectAttributes) {
        movieService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Movie deleted successfully.");
        return "redirect:/movies";
    }

    public Movie convertMovieDtoToMovie(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setId(movieDto.getId());
        movie.setTitle(movieDto.getTitle());
        movie.setDirector(movieDto.getDirector());
        movie.setReleaseDate(movieDto.getReleaseDate());
        movie.setGenre(movieDto.getGenre());
        return movie;
    }
    public Movie convertMovieDtoUpdateToMovie(MovieDtoUpdate movieDtoUpdate) {
        Movie movie = new Movie();
        movie.setId(movieDtoUpdate.getId());
        movie.setTitle(movieDtoUpdate.getTitle());
        movie.setDirector(movieDtoUpdate.getDirector());
        movie.setReleaseDate(movieDtoUpdate.getReleaseDate());
        movie.setGenre(movieDtoUpdate.getGenre());
        return movie;
    }
    public MovieDto convertMovieToMovieDto(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setDirector(movie.getDirector());
        movieDto.setReleaseDate(movie.getReleaseDate());
        movieDto.setGenre(movie.getGenre());
        return movieDto;
    }

    public MovieDtoUpdate convertMovieToMovieDtoUpdate(Movie movie) {
        MovieDtoUpdate movieDtoUpdate = new MovieDtoUpdate();
        movieDtoUpdate.setId(movie.getId());
        movieDtoUpdate.setTitle(movie.getTitle());
        movieDtoUpdate.setDirector(movie.getDirector());
        movieDtoUpdate.setReleaseDate(movie.getReleaseDate());
        movieDtoUpdate.setGenre(movie.getGenre());
        return movieDtoUpdate;
    }

}
