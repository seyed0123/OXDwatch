package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

class NetflixService {
    HashMap<String, User> users;
    ArrayList<TVShow> shows;
    /*
     *The NetflixService should have an Arraylist of users, tv shows and movies.
     *The NetflixService should have a User object which represents current user.
     */

    public void addTVShow(TVShow tvShow){
       shows.add(tvShow);
    }

    public void addMovie(Movie movie){
        shows.add(movie);
    }

    public void createAccount(String username, String password) {
        User user = new User(username , password);
        users.put(username , user);
    }

    public boolean login(String username, String password) {
        return users.get(username).checkPassword(password);
    }

    public void logout() {
        // Implement logout logic here
    }

    public ArrayList<TVShow> searchByTitle(String title) {
       ArrayList<TVShow> ret = new ArrayList<>();
       for (TVShow show : shows)
       {
           if(Objects.equals(show.getTitle(), title))
               ret.add(show);
       }
        return ret;
    }

    public ArrayList<TVShow> searchByGenre(String genre) {
        ArrayList<TVShow> ret = new ArrayList<>();
        for (TVShow show : shows)
        {
            if(Objects.equals(show.getGenre(), genre))
                ret.add(show);
        }
        return ret;
    }

    public ArrayList<TVShow> searchByReleaseYear(double year) {
        ArrayList<TVShow> ret = new ArrayList<>();
        for (TVShow show : shows)
        {
            if(show.getReleaseYear() == year)
                ret.add(show);
        }
        return ret;
    }
    public ArrayList<TVShow> getRecommendations(String username)
    {
        ArrayList<TVShow> ret = new ArrayList<>();
        String genre = users.get(username).getRecommendations();
        for (TVShow show : shows)
        {
            if(Objects.equals(show.getGenre(), genre))
                ret.add(show);
        }
        return ret;
    }
    public boolean addToFavorites(String username , String title)
    {
        TVShow show = null;
        for(TVShow tempShow : shows)
        {
            if(Objects.equals(tempShow.getTitle(), title))
                show=tempShow;
        }
        if(show==null)
            return false;
        users.get(username).addToFavorites(show);
        return true;
    }
}

