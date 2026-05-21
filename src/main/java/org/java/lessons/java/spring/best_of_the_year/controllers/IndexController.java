package org.java.lessons.java.spring.best_of_the_year.controllers;

import java.util.ArrayList;
import java.util.List;

import org.java.lessons.java.spring.best_of_the_year.models.Movie;
import org.java.lessons.java.spring.best_of_the_year.models.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Saverio");
        return "index";
    }

    // movies e songs come stringa:
    @GetMapping("/string/movies")
    public String moviesAString(Model model) {

        String names = "";
        int i = 0;

        for (Movie movie : getBestMovies()) {
            names += movie.getTitle();

            if (i < getBestMovies().size() - 1) {
                names += ", ";
            }

            i++;
        }

        model.addAttribute("names", names);
        model.addAttribute("title", "Movies");

        return "listAsString";
    }

    @GetMapping("/string/songs")
    public String songsAString(Model model) {

        String names = "";
        int i = 0;

        for (Song song : getBestSongs()) {
            names += song.getTitle();

            if (i < getBestSongs().size() - 1) {
                names += " ~ ";
            }

            i++;
        }

        model.addAttribute("title", "Songs");
        model.addAttribute("names", names);

        return "listAsString";
    }

    // movies e songs come lista:
    @GetMapping("/movies")
    public String movies(Model model) {

        model.addAttribute("title", "Movies");
        model.addAttribute("list", getBestMovies());

        return "list";
    }

    @GetMapping("/songs")
    public String songs(Model model) {

        model.addAttribute("title", "Songs");
        model.addAttribute("list", getBestSongs());

        return "list";
    }

    // movies e songs rotta di dettaglio
    @GetMapping("/movies/{id}")
    public String movieDetail(Model model, @PathVariable("id") Integer movieId) {
        Movie movieFound = null;

        for (Movie movie : getBestMovies()) {
            if (movie.getId() == movieId) {
                movieFound = movie;
                break;
            }
        }

        model.addAttribute("id", movieId);
        model.addAttribute("item", movieFound);

        return "details";
    }

    @GetMapping("/songs/{id}")
    public String songDetail(Model model, @PathVariable("id") Integer songId) {
        Song songFound = null;

        for (Song song : getBestSongs()) {
            if (song.getId() == songId) {
                songFound = song;
                break;
            }
        }

        model.addAttribute("id", songId);
        model.addAttribute("item", songFound);

        return "details";
    }

    // metodi private che restituiscono lista di movies e di songs:
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
