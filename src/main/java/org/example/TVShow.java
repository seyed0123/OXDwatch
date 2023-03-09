package org.example;

import java.util.ArrayList;
import java.util.Objects;

class TVShow {
    private String title;
    private String genre;
    private double releaseYear;
    private double duration;
    private double rating;

    public TVShow(String title, String genre, double releaseYear, double duration, double rating) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.rating = rating;
    }
    /*
    * The TVShow should have a title , genre, release year, duration and a rating.
    * The TVShow should have an ArrayList of the cast.
     */

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(double releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    public boolean equals(TVShow tvShow)
    {
        return Objects.equals(this.title, tvShow.getTitle()) && Objects.equals(this.genre, tvShow.getGenre()) && this.releaseYear == tvShow.getReleaseYear() && this.duration == tvShow.getDuration() && this.rating == tvShow.rating;
    }

    @Override
    public String toString() {
        return "TVShow{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseYear=" + releaseYear +
                ", duration=" + duration +
                ", rating=" + rating +
                '}';
    }
}
