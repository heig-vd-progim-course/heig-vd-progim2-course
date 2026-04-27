// Classe Movie avec equals() et hashCode() redéfinis.
// Deux films sont considérés identiques s'ils ont le même titre et la même année.

public class Movie {

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
        // 1. Optimisation : même référence
        if (this == obj) {
            return true;
        }
        // 2. Vérification du type
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        // 3. Comparaison des champs discriminants
        Movie other = (Movie) obj;
        return year.equals(other.year)
                && title.equals(other.title);
    }

    @Override
    public int hashCode() {
        // Doit utiliser les mêmes champs que equals()
        int result = title.hashCode();
        result = 31 * result + year.hashCode();
        return result;
    }
}
