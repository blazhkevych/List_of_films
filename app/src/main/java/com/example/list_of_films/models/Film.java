package com.example.list_of_films.models;

/**
 * This class represents a Film object with a title, genre, and year.
 */
public class Film {
    // The title of the film
    String title;
    // The genre of the film
    String genre;
    // The year the film was released
    int year;

    /**
     * Constructs a new Film with the specified title, genre, and year.
     *
     * @param title The title of the film.
     * @param genre The genre of the film.
     * @param year  The year the film was released.
     */
    public Film(String title, String genre, int year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    /**
     * Returns the title of the film.
     *
     * @return A string representing the title of the film.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the genre of the film.
     *
     * @return A string representing the genre of the film.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Returns the year the film was released.
     *
     * @return An integer representing the year the film was released.
     */
    public int getYear() {
        return year;
    }
}