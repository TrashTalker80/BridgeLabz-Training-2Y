import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class Movie {
    private String title;
    private String genre;

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return title + " [" + genre + "]";
    }
}

public class OnlineStreamingWatchHistory {
    private Stack<Movie> watchHistory;
    private List<Movie> allMovies;
    private Set<String> genresWatched;
    private Queue<Movie> upNextQueue;

    public OnlineStreamingWatchHistory() {
        watchHistory = new Stack<>();
        allMovies = new ArrayList<>();
        genresWatched = new HashSet<>();
        upNextQueue = new LinkedList<>();
    }

    public void addMovie(Movie movie) {
        allMovies.add(movie);
        System.out.println("Movie added: " + movie);
    }

    public void addToUpNext(Movie movie) {
        upNextQueue.add(movie);
        System.out.println("Added to Up Next: " + movie);
    }

    public void watchMovie() {
        if (!upNextQueue.isEmpty()) {
            Movie movie = upNextQueue.poll();
            watchHistory.push(movie);
            genresWatched.add(movie.getGenre());
            System.out.println("\nWatching: " + movie);
        }
    }

    public void displayHistory() {
        System.out.println("\nWatch History:");
        for (Movie movie : watchHistory) {
            System.out.println(movie);
        }
    }

    public void displayGenres() {
        System.out.println("\nGenres Watched: " + genresWatched);
    }

    public static void main(String[] args) {
        OnlineStreamingWatchHistory system = new OnlineStreamingWatchHistory();

        system.addMovie(new Movie("Inception", "Sci-Fi"));
        system.addMovie(new Movie("The Matrix", "Sci-Fi"));
        system.addMovie(new Movie("The Godfather", "Crime"));

        system.addToUpNext(new Movie("Inception", "Sci-Fi"));
        system.addToUpNext(new Movie("The Godfather", "Crime"));

        system.watchMovie();
        system.watchMovie();

        system.displayHistory();
        system.displayGenres();
    }
}
