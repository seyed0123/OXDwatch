package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;
public class Main {
    /*
     * make a functional library app using oop
     * run the main program in Main.java and code the oop part in other classes
     * don't forget to add at least 1 librarian to the library to make it functionable.
     * *  *** don't limit yourself to our template ***
     */
    public static void main(String[] args)
    {
        login();
    }
    static NetflixService NS= new NetflixService();
    static public String getNumberString(String dialog)
    {
        String input;
        while(true)
        {
            input =JOptionPane.showInputDialog(dialog);
            String num ="1234567890";
            boolean flag=true;
            for(int i = 0 ; i < input.length() ; i++)
            {
                if (!num.contains("" + input.charAt(i))) {
                    flag = false;
                    break;
                }
            }if(flag)
            break;
        else
            JOptionPane.showMessageDialog(null, "Was machst du bro?.");
        }
        return input;
    }
    public static void login()
    {
        boolean res;
        String name,password;
        while (true) {
            String response = JOptionPane.showInputDialog("do you have an account? (yes/no)");
            if(Objects.equals(response, "no"))
            {
                String newName = JOptionPane.showInputDialog("Enter the username");
                String newPassword = JOptionPane.showInputDialog("Enter the password");
                if(!NS.createAccount(newName , newPassword))
                    JOptionPane.showMessageDialog(null, "the username is already in use.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            name = JOptionPane.showInputDialog("Enter the your username");
            password = JOptionPane.showInputDialog("Enter the password");
            if((name==null || password==null))
                System.exit(0);
            if(name.equals("admin") && password.equals("admin"))
                break;
            res = NS.login(name, password);
            if (res) {
                break;
            } else
                JOptionPane.showMessageDialog(null, "the username or the password is wrong.", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        if(name.equals("admin") && password.equals("admin")) {
            while (true)
                if (adminMenu())
                    break;
        }
        else {
            while (true)
                if (Menu(name))
                    break;
        }
        login();
    }
    static String Input()
    {
        return JOptionPane.showInputDialog("1-add TVShow\n2-add movie\n3-search by title\n4-search by genre\n5-search by year\n6-get Recommendations\n7-add to favorite\n8-show favorite\n9-search by title in favorite\n10-search by genre in favorite\n11-search by year in favorite\n12-change password\n13-logout");
    }
    static boolean Menu(String username)
    {
        String commend = Input();
        if(Objects.equals(commend, "1"))
        {
            String name = JOptionPane.showInputDialog("Enter the show name");
            String genre = JOptionPane.showInputDialog("Enter the show genre");
            int year = Integer.parseInt(getNumberString("Enter the show released year (Write numerically)"));
            int duration = Integer.parseInt(getNumberString("Enter the show duration (Write numerically)"));
            int rating = Integer.parseInt(getNumberString("Enter the show rating (Write numerically)"));
            TVShow temp = new TVShow(name,genre ,year , duration ,rating);
            if(!NS.addTVShow(temp))
                JOptionPane.showMessageDialog(null, "this show already added.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else if(Objects.equals(commend, "2"))
        {
            String name = JOptionPane.showInputDialog("Enter the show name");
            String genre = JOptionPane.showInputDialog("Enter the show genre");
            int year = Integer.parseInt(getNumberString("Enter the show released year (Write numerically)"));
            int duration = Integer.parseInt(getNumberString("Enter the show duration (Write numerically)"));
            int rating = Integer.parseInt(getNumberString("Enter the show rating (Write numerically)"));
            int length = Integer.parseInt(getNumberString("Enter the show length (Write numerically)"));
            Movie temp = new Movie(name,genre ,year , duration ,rating , length);
            if(!NS.addTVShow(temp))
                JOptionPane.showMessageDialog(null, "this movie already added.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else if (Objects.equals(commend, "3"))
        {
            String name = JOptionPane.showInputDialog("Enter the show title.");
            ArrayList<TVShow> title = new ArrayList<>(NS.searchByTitle(name));
            StringBuilder massage= new StringBuilder();
            for(TVShow show : title)
                massage.append(show.toString()).append("\n");

            JOptionPane.showMessageDialog(null, massage.toString());
        }else if (Objects.equals(commend, "4"))
        {
            String genre = JOptionPane.showInputDialog("Enter the show genre.");
            ArrayList<TVShow> title = new ArrayList<>(NS.searchByGenre(genre));
            StringBuilder massage= new StringBuilder();
            for(TVShow show : title)
                massage.append(show.toString()).append("\n");

            JOptionPane.showMessageDialog(null, massage.toString());
        }else if(Objects.equals(commend, "5"))
        {
            int year = Integer.parseInt(getNumberString("Enter the show released year."));
            ArrayList<TVShow> title = new ArrayList<>(NS.searchByReleaseYear(year));
            StringBuilder massage= new StringBuilder();
            for(TVShow show : title)
                massage.append(show.toString()).append("\n");

            JOptionPane.showMessageDialog(null, massage.toString());
        }else if(Objects.equals(commend, "6"))
        {
            ArrayList<TVShow> title = new ArrayList<>(NS.getRecommendations(username));
            StringBuilder massage= new StringBuilder();
            for(TVShow show : title)
                massage.append(show.toString()).append("\n");

            JOptionPane.showMessageDialog(null, massage.toString());
        }else if (Objects.equals(commend, "7"))
        {
            String name = JOptionPane.showInputDialog("Enter the show name");
            String genre = JOptionPane.showInputDialog("Enter the show genre");
            int year = Integer.parseInt(getNumberString("Enter the show released year (Write numerically)"));
            if(!NS.addToFavorites(username , name,genre ,year))
                JOptionPane.showMessageDialog(null, "this show doesn't found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (Objects.equals(commend, "8"))
        {
            JOptionPane.showMessageDialog(null, NS.showStatus(username));
        }else if (Objects.equals(commend, "9"))
        {
            String name = JOptionPane.showInputDialog("Enter the show favorite title.");
            ArrayList<TVShow> title = new ArrayList<>(NS.searchByTitleFavorite(name , username));
            StringBuilder massage= new StringBuilder();
            for(TVShow show : title)
                massage.append(show.toString()).append("\n");

            JOptionPane.showMessageDialog(null, massage.toString());
        }else if (Objects.equals(commend, "10"))
        {
            String genre = JOptionPane.showInputDialog("Enter the show your favorite genre .");
            ArrayList<TVShow> title = new ArrayList<>(NS.searchByGenreFavorite(genre ,username));
            StringBuilder massage= new StringBuilder();
            for(TVShow show : title)
                massage.append(show.toString()).append("\n");

            JOptionPane.showMessageDialog(null, massage.toString());
        }else if(Objects.equals(commend, "11"))
        {
            int year = Integer.parseInt(getNumberString("Enter the show your favorite released year."));
            ArrayList<TVShow> title = new ArrayList<>(NS.searchByReleaseYearFavorite(year ,username));
            StringBuilder massage= new StringBuilder();
            for(TVShow show : title)
                massage.append(show.toString()).append("\n");

            JOptionPane.showMessageDialog(null, massage.toString());
        } else if (commend == "12") {
            String password = JOptionPane.showInputDialog("Enter the new password");
            String oldPassword = JOptionPane.showInputDialog("Enter the your old password");
            if(NS.changePassword(username,password,oldPassword))
                JOptionPane.showMessageDialog(null, "done!!");
            else
                JOptionPane.showMessageDialog(null, "the old password is wrong.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (Objects.equals(commend, "13") || commend == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Was machst du bro?.");
        }
        return false;
    }
    public static boolean adminMenu()
    {
        String commend = JOptionPane.showInputDialog("1-add TVShow\n2-add movie\n3-logout");
        if(Objects.equals(commend, "1"))
        {
            String name = JOptionPane.showInputDialog("Enter the show name");
            String genre = JOptionPane.showInputDialog("Enter the show genre");
            int year = Integer.parseInt(getNumberString("Enter the show released year (Write numerically)"));
            int duration = Integer.parseInt(getNumberString("Enter the show duration (Write numerically)"));
            int rating = Integer.parseInt(getNumberString("Enter the show rating (Write numerically)"));
            TVShow temp = new TVShow(name,genre ,year , duration ,rating);
            if(!NS.addTVShow(temp))
                JOptionPane.showMessageDialog(null, "this show already added.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else if(Objects.equals(commend, "2"))
        {
            String name = JOptionPane.showInputDialog("Enter the show name");
            String genre = JOptionPane.showInputDialog("Enter the show genre");
            int year = Integer.parseInt(getNumberString("Enter the show released year (Write numerically)"));
            int duration = Integer.parseInt(getNumberString("Enter the show duration (Write numerically)"));
            int rating = Integer.parseInt(getNumberString("Enter the show rating (Write numerically)"));
            int length = Integer.parseInt(getNumberString("Enter the show length (Write numerically)"));
            Movie temp = new Movie(name,genre ,year , duration ,rating , length);
            if(!NS.addTVShow(temp))
                JOptionPane.showMessageDialog(null, "this movie already added.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else if (Objects.equals(commend, "3") || commend == null) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Was machst du bro?.");
        }
        return false;
    }
}