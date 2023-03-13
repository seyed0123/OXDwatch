package org.example;

class Movie extends TVShow {
    private final int length;
    /*
     *Movie is extended from TVShow and has extra attribute length.
     */
    public Movie(String title, String genre, double releaseYear, double duration, double rating , int length)
    {
        super( title, genre,releaseYear,duration, rating);
        this.length=length;
    }
    public int getLength() {
        return length;
    }
    @Override
    public String toString() {
        return super.toString()+"Movie{" +
                "length='" + length + '\'' +
                '}';
    }
    public boolean equals(Movie movie)
    {
        return this.length==movie.getLength() && super.equals(movie);
    }
}
