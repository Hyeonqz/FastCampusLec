package collection;

import java.time.LocalDateTime;

public class Movie {
    private String title;
    private String director;
    private LocalDateTime years;
    private String country;
    public Movie() {
    }
    public Movie(String title, String director, LocalDateTime years, String country) {
        this.title = title;
        this.director = director;
        this.years = years;
        this.country = country;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDateTime getYears() {
        return years;
    }

    public void setYears(LocalDateTime years) {
        this.years = years;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", years=" + years +
                ", country='" + country + '\'' +
                '}';
    }


}
