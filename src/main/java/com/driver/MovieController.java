package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.lang.*;

@RestController
//@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieServices;

//    @PutMapping
//    @DeleteMapping
//    @GetMapping

    @PostMapping("/add_movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieServices.addMovie(movie);
//        String response = movieServices.addMovie(movie);
        return new ResponseEntity<>("new movie added successfully.", HttpStatus.CREATED);
    }

    @PostMapping("/add_director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieServices.addDirector(director);
//        String response = movieService.addDirector(director);
        return new ResponseEntity<>("new director added successfully.", HttpStatus.CREATED);
    }

    @PutMapping("/add_movie_director_pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie, @RequestParam("director") String director){
        movieServices.createMovieDirectorPair(movie, director);
        return new ResponseEntity<>("new movie-director pair added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get_movie_by_name/{name}")
    public ResponseEntity<Movie> getMovieByName (@PathVariable String name){
        Movie movies = movieServices.findMovie(name);
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }

    @GetMapping("/get_director_by_name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director directors = movieServices.findDirector(name);
        return new ResponseEntity<>(directors, HttpStatus.CREATED);
    }

    @GetMapping("/get_movies_by_director_name")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String>movies = movieServices.findMoviesFromDirector(director);
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }

    @GetMapping("/get_all_movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String>movies = movieServices.findAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_director_by_name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){
        movieServices.deleteDirector(director);
        return new ResponseEntity<>(director+" removed successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_all_directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieServices.deleteAllDirectors();
        return new ResponseEntity<>("all directors deleted successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get_director_name_from_movie")
    public String getDirectorName(@RequestParam String movie){
        return movieServices.getDirectorName(movie);
    }



//    @PostMapping("/movies/add-movie")
//    public ResponseEntity addMovie(@RequestBody Movie movie){
//
//        String response = movieService.addMovie(movie);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//    @PostMapping("/movies/add-director")
//    public ResponseEntity addDirector(@RequestBody Director director){
//
//        String response = movieService.addDirector(director);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }


//        @GetMapping("/get_student")
//        public ResponseEntity getStudent(@RequestParam("admnNo") int admnNo){
//            Student student = studentService.getStudent(admnNo);
//            return new ResponseEntity<>(student, HttpStatus.FOUND);
//        }
//    @DeleteMapping("/delete_student/{id}")
//    public ResponseEntity deleteStudent(@PathVariable("id") int id){
//        String response = studentService.delete_Student(id);
//        if(response.equals("Invalid id")){
//            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<>(response,HttpStatus.FOUND);
//    }
//    @PutMapping("/update_student")
//    public ResponseEntity updateStudent(@RequestParam("id") int id,@RequestParam("age") int age){
//        String response = studentService.updateStudent(id,age);
//        if(response==null){
//            return new ResponseEntity("Invalid request",HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity("Updated",HttpStatus.ACCEPTED);
//    }

}
