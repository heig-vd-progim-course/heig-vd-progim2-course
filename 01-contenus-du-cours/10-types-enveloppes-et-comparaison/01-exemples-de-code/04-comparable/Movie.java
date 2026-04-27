// Classe Movie avec equals(), hashCode() et Comparable<Movie>.
// Ordre naturel : par note décroissante (meilleure note en premier).

public class Movie implements Comparable<Movie> {

    private String title;
    private Integer year;
    private Integer duration;  // en minutes
    private Double rating;     // note sur 10

    public Movie(String title, Integer year, Integer duration, Double rating) {
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getDuration() {
        return duration;
    }

    public Double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return title + " (" + year + ") - " + rating + "/10";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Movie other = (Movie) obj;
        return year.equals(other.year)
                && title.equals(other.title);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + year.hashCode();
        return result;
    }

    @Override
    public int compareTo(Movie other) {
        // Ordre décroissant : other.rating avant this.rating
        // Double.compare(a, b) retourne :
        //   négatif si a < b, 0 si a == b, positif si a > b
        return Double.compare(other.rating, this.rating);
    }
}
