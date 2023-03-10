package com.driver;
import java.lang.String;

public class Movie {
//    String name, int durationInMinutes, double imdbRating, no-args constructor, all-args constructor
    private String name;
    private int durationInMinutes;
    private double imdbRating;
    private Director director;


    //    no suitable constructor found for Movie(java.lang.String,int,double)
    public Movie(String name, int durationInMinutes, double imdbRating){
        this.name = name;
        this.durationInMinutes = durationInMinutes;
        this.imdbRating = imdbRating;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public Movie(){

    }
//    no suitable constructor found for Movie(java.lang.String,int,double)

//    public Movie(String name,Director director, int durationInMinutes, double imdbRating){
//        this.name = name;
//        this.director = director;
//        this.durationInMinutes = durationInMinutes;
//        this.imdbRating = imdbRating;
//    }

}
