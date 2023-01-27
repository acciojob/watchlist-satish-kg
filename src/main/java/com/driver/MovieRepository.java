package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.lang.*;

@Repository
public class MovieRepository {
    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMap;

    public MovieRepository(){
        this.movieMap = new HashMap<String, Movie>();
        this.directorMap = new HashMap<String, Director>();
        this.directorMovieMap = new HashMap<String, List<String>>();
    }

    public void addMovie(Movie movie){
        movieMap.put(movie.getName(), movie);
    }

    public void addDirector(Director director){
        directorMap.put(director.getName(), director);
    }

    public void saveMovieDirectorPair(String movie, String director){
        if(movieMap.containsKey(movie) && directorMap.containsKey(director)){
            movieMap.put(movie, movieMap.get(movie));
            directorMap.put(director, directorMap.get(director));
            List<String> currentMovies = new ArrayList<>();
            if(directorMovieMap.containsKey(director)) currentMovies = directorMovieMap.get(director);
            currentMovies.add(movie);
            directorMovieMap.put(director, currentMovies);
        }
    }

    public Movie findMovie (String movie){
        return movieMap.get(movie);
    }

    public Director findDirector(String director){
        return directorMap.get(director);
    }

    public List<String> findMoviesFromDirector (String director){
        List<String> movieList = new ArrayList<>();
        if(directorMovieMap.containsKey(director)) movieList = directorMovieMap.get(director);
        return movieList;
    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector(String director){
        List<String> movies = new ArrayList<>();
        if(directorMovieMap.containsKey(director)){
            movies = directorMovieMap.get(director);
            for(String movie : movies){
                if(movieMap.containsKey(movie)){
                    movieMap.remove(movie);
                }
            }
            directorMovieMap.remove(director);
        }
        if(directorMap.containsKey(director)){
            directorMap.remove(director);
        }
    }

    public void deleteAllDirectors(){
        HashSet<String> movieSet = new HashSet<>(0);
        for(String director : directorMovieMap.keySet()){
            for(String movie : directorMovieMap.get(director)){
                movieSet.add(movie);
            }
        }
        for(String movie : movieSet){
            if(movieMap.containsKey(movie)){
                movieMap.remove(movie);
            }
        }
    }

    public String getDirectorName(String movie){
        HashSet<String> movieSet = new HashSet<>();
        for(String director : directorMovieMap.keySet()){
            if(directorMovieMap.get(director).contains(movie)){
                return director;
            }
        }
        return "No Such Movie Found!";
    }

    /*
    Pair an existing movie and director: PUT /movies/add-movie-director-pair
    Pass movie name and director name as request parameters
    Return success message wrapped in a ResponseEntity object
    Controller Name - addMovieDirectorPair
     */




//    public Student getStudent(int id){
//        return db.get(id);
//    }
//
//    public String deleteStudent(int id){
//        if(!db.containsKey(id)){
//            return "Invalid Id";
//        }
//        db.remove(id);
//        return "Student removed succesfully";
//    }
//
//    public String updateStudent(int id, int age){
//
//        if(!db.containsKey(id)){
//            return null;
//        }
//        db.get(id).setAge(20);
//        return "Age updated succesfully";
//    }
}

/*


Pair an existing movie and director: PUT /movies/add-movie-director-pair
Pass movie name and director name as request parameters
Return success message wrapped in a ResponseEntity object
Controller Name - addMovieDirectorPair

Get Movie by movie name: GET /movies/get-movie-by-name/{name}
Pass movie name as path parameter
Return Movie object wrapped in a ResponseEntity object
Controller Name - getMovieByName

Get Director by director name: GET /movies/get-director-by-name/{name}
Pass director name as path parameter
Return Director object wrapped in a ResponseEntity object
Controller Name - getDirectorByName

Get List of movies name for a given director name: GET /movies/get-movies-by-director-name/{director}
Pass director name as path parameter
Return List of movies name(List()) wrapped in a ResponseEntity object
Controller Name - getMoviesByDirectorName

Get List of all movies added: GET /movies/get-all-movies
No params or body required
Return List of movies name(List()) wrapped in a ResponseEntity object
Controller Name - findAllMovies

Delete a director and its movies from the records: DELETE /movies/delete-director-by-name
Pass director’s name as request parameter
Return success message wrapped in a ResponseEntity object
Controller Name - deleteDirectorByName

Delete all directors and all movies by them from the records: DELETE /movies/delete-all-directors
No params or body required
Return success message wrapped in a ResponseEntity object
Controller Name - deleteAllDirectors
(Note that there can be some movies on your watchlist that aren’t mapped to any of the director. Make sure you do not remove them.)
 */
