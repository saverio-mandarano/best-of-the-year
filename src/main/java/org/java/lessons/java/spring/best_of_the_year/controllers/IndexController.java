package org.java.lessons.java.spring.best_of_the_year.controllers;

import java.util.ArrayList;
import java.util.List;

import org.java.lessons.java.spring.best_of_the_year.models.Movie;
import org.java.lessons.java.spring.best_of_the_year.models.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Saverio");
        return "index";
    }

    @GetMapping("/movies")
    public String movies(Model model) {

        String titles = "";
        int i = 0;

        for (Movie movie : getBestMovies()) {
            titles += movie.getTitle();

            if (i < getBestMovies().size() - 1) {
                titles += ", ";
            }

            i++;
        }

        model.addAttribute("movies", titles);

        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {

        String songs = "";
        int i = 0;

        for (Song song : getBestSongs()) {
            songs += song.getTitle();

            if (i < getBestSongs().size() - 1) {
                songs += ", ";
            }

            i++;
        }

        model.addAttribute("songs", songs);

        return "songs";
    }

    private List<Movie> getBestMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Il Padrino"));
        movies.add(new Movie(2, "Titanic"));
        movies.add(new Movie(3, "Batman"));

        return movies;
    }

    private List<Song> getBestSongs() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "Cigarette Daydreams"));
        songs.add(new Song(2, "Cradles"));
        songs.add(new Song(3, "Something In The Way"));

        return songs;
    }
}
