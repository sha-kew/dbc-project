
package edu.rit.cs.dbc;

/**
 *
 * @author pjd2424
 */
public class Movie {
    private String title, genre;
    private int year, movie_id;
    private float score;

    public Movie(String title, String genre, int year, int movie_id, float score) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.movie_id = movie_id;
        this.score = score;
    }

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    
}
