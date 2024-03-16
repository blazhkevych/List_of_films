package com.example.list_of_films.models;

public class Film {
    String title;
    String genre;
    int year;

    public Film(String title, String genre, int year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }
}
