package org.example;

import java.util.ArrayList;

class Movie extends TVShow {
    private String length;
    /*
     *Movie is extended from TVShow and has extra attribute length.
     */
    public Movie(String title, String genre, double releaseYear, double duration, double rating , String length)
    {
        super( title, genre,releaseYear,duration, rating);
        this.length=length;
    }
    public String getLength() {
        return length;
    }
    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return super.toString()+"Movie{" +
                "length='" + length + '\'' +
                '}';
    }
}
