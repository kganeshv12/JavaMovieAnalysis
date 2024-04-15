package com.cs253.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cs253.demo.model.*;
import com.cs253.demo.MovieService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.view.RedirectView;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/addMovie")
    public RedirectView postDetails(@RequestParam("title") String title,
            @RequestParam("releaseYear") int releaseYear,
            @RequestParam("genre") String genre,
            @RequestParam("director") String director,
            @RequestParam("averageRating") double averageRating,
            RedirectAttributes redirectAttributes) {
        try {
            Movie movie = new Movie();
            movie.setTitle(title);
            movie.setReleaseYear(releaseYear);
            movie.setGenre(genre);
            movie.setDirector(director);
            movie.setAverageRating(averageRating);

            movieService.saveDetails(movie);
            redirectAttributes.addFlashAttribute("successMessage", "Movie added successfully.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to add movie. Please try again.");
        }
        return new RedirectView("/getMovies", true);
    }

    @GetMapping("/getMovies")
    public ModelAndView getDetails(Model model) {
        Iterable<Movie> movies = movieService.getAllDetails();
        model.addAttribute("movies", movies);
        return new ModelAndView("movies");
    }

    @PostMapping("/updateRating")
    public RedirectView updateRating(@RequestParam("movieId") Integer movieId,
            @RequestParam("newRating") double newRating,
            RedirectAttributes redirectAttributes) {
        try {
            if (newRating < 1 || newRating > 5) {
                throw new IllegalArgumentException("Rating must be between 1 and 5.");
            }

            Movie movie = movieService.getById(movieId);
            double oldRating = movie.getAverageRating();
            double updatedRating = (oldRating + newRating) / 2.0;
            movie.setAverageRating(updatedRating);
            movieService.saveDetails(movie);
            redirectAttributes.addFlashAttribute("successMessage", "Rating updated successfully.");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Rating must be between 1 and 5.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to update rating. Please try again.");
        }
        return new RedirectView("/getMovies", true);
    }

}
