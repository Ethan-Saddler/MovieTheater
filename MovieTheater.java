import java.util.ArrayList;


public class MovieTheater {
    private ArrayList<String> movies;
    private ArrayList<String> watched;

    public MovieTheater(ArrayList<String> movies, ArrayList<String>watched) {
        this.movies = new ArrayList<String>(movies);
        this.watched = new ArrayList<String>(watched);
    }

    public void throwIfMoviesMissing (ArrayList<String> interestingMovies) throws FilmNotFoundException {
        for (String movie : interestingMovies) {
            if (!movies.contains(movie)) {
                throw new FilmNotFoundException(movie);
            }
        }
    }
    
    public void watchMovie(String movie) throws FilmNotFoundException {
        if (movies.contains(movie)) {
            if (watched.contains(movie)) {
                throw new AlreadyWatchedException();
            }
        } else {
            throw new FilmNotFoundException(movie);
        }
    }
    public ArrayList<String> selectRecommended(ArrayList<String> recommendedMovies) {
        ArrayList<String> willSee = new ArrayList<String>();
        for (String movie : recommendedMovies) {
            if (movies.contains(movie)) {
                willSee.add(movie);
            }
        }
        return willSee;
    }

    public static void main(String[] args) {
        ArrayList<String> recommendations = new ArrayList<String>();
        recommendations.add("1");
        recommendations.add("2");
        recommendations.add("11");

        ArrayList<String> movies = new ArrayList<String>();
        movies.add("1");
        movies.add("2");
        movies.add("3");
        movies.add("4");
        movies.add("5");

        ArrayList<String> watched = new ArrayList<String>();
        watched.add("2");
        watched.add("4");
        watched.add("6");
        watched.add("8");

        MovieTheater theater = new MovieTheater(movies, watched);

        try {
            theater.throwIfMoviesMissing(movies);
            theater.watchMovie("2");
            theater.watchMovie("10");
            System.out.println(theater.selectRecommended(recommendations));
        } catch (FilmNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (AlreadyWatchedException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Took a look at the movies!");
        }

    }
}
