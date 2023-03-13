package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Objects;

class User {
    /*
    * The user should contain username password.
    * The user should contain an ArrayList of favorite shows and watch history.
    * FUNCTION: the user should have a function to watch a show and add it to watch history.
    *  *** NOTE: All search functions in user are for searching in favorite shows ***
    */

    private final String username;
    private String password;
    private String lastGenre;
    private final ArrayList <TVShow> favoriteShow;
    private final ArrayList <TVShow> watchList;
    public User (String name ,String password)
    {
        this.username = name;
        this.password=HashPassword(password);
        favoriteShow = new ArrayList<>();
        watchList = new ArrayList<>();
    }
    private String HashPassword(String passwordToHash)
    {
        String generatedPassword = null;
        try
        {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Add password bytes to digest
            md.update(passwordToHash.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }

            // Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //System.out.println(generatedPassword);
        return generatedPassword;
    }
    public boolean setPassword(String password , String oldPassword)
    {
        if(!Objects.equals(HashPassword(oldPassword),this.password))
            return false;
        this.password=HashPassword(password);
        return true;
    }
    public boolean checkPassword(String password)
    {
        String genPass=HashPassword(password);
        return Objects.equals(this.password, genPass);
    }
    public boolean addToFavorites(TVShow show) {
        // Implement add to favorites logic here
        if(favoriteShow.contains(show))
            return false;
        this.favoriteShow.add(show);
        this.lastGenre = show.getGenre();
        return true;
    }
    public boolean addToWatchList(TVShow show)
    {
        if(watchList.contains(show))
            return false;
        this.watchList.add(show);
        return true;
    }
    public String getRecommendations() {
        return this.lastGenre;
    }
    public ArrayList<TVShow> searchByTitle(String title) {
        ArrayList<TVShow> ret = new ArrayList<>();
        for (TVShow show : this.favoriteShow)
        {
            if(Objects.equals(show.getTitle(), title))
                ret.add(show);
        }
        return ret;
    }

    public ArrayList<TVShow> searchByGenre(String genre) {
        ArrayList<TVShow> ret = new ArrayList<>();
        for (TVShow show : this.favoriteShow)
        {
            if(Objects.equals(show.getGenre(), genre))
                ret.add(show);
        }
        return ret;
    }

    public ArrayList<TVShow> searchByReleaseYear(double year) {
        ArrayList<TVShow> ret = new ArrayList<>();
        for (TVShow show : this.favoriteShow)
        {
            if(show.getReleaseYear() == year)
                ret.add(show);
        }
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("User{" +
                "username='" + username + '\'' +
                ", lastGenre='" + lastGenre + '\'' +
                ", favoriteShow=\n");
        if(this.favoriteShow.size()==0)
            ret.append((String) null);
        for (TVShow show : this.favoriteShow)
        {
            ret.append(show.toString());
            ret.append("\n");
        }
        ret.append(", WatchList=\n");
        if(this.watchList.size()==0)
            ret.append((String) null);
        for (TVShow show : this.watchList)
        {
            ret.append(show.toString());
            ret.append("\n");
        }
        ret.append("}");
        return ret.toString();
    }
}
