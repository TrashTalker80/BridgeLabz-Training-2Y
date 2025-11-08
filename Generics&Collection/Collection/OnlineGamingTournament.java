import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

class Player {
    private String playerId;
    private String name;

    public Player(String playerId, String name) {
        this.playerId = playerId;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(playerId, player.playerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId);
    }

    @Override
    public String toString() {
        return playerId + " - " + name;
    }
}

class Match {
    private String matchId;
    private String player1;
    private String player2;

    public Match(String matchId, String player1, String player2) {
        this.matchId = matchId;
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public String toString() {
        return matchId + ": " + player1 + " vs " + player2;
    }
}

class Result {
    private String matchId;
    private String winner;

    public Result(String matchId, String winner) {
        this.matchId = matchId;
        this.winner = winner;
    }

    @Override
    public String toString() {
        return matchId + " - Winner: " + winner;
    }
}

class Score implements Comparable<Score> {
    private String playerId;
    private int points;

    public Score(String playerId, int points) {
        this.playerId = playerId;
        this.points = points;
    }

    @Override
    public int compareTo(Score other) {
        return Integer.compare(other.points, this.points);
    }

    @Override
    public String toString() {
        return playerId + ": " + points + " points";
    }
}

public class OnlineGamingTournament {
    private Set<Player> players;
    private Queue<Match> matchQueue;
    private List<Result> results;
    private TreeSet<Score> leaderboard;

    public OnlineGamingTournament() {
        players = new HashSet<>();
        matchQueue = new LinkedList<>();
        results = new ArrayList<>();
        leaderboard = new TreeSet<>();
    }

    public void registerPlayer(Player player) {
        if (players.add(player)) {
            System.out.println("Player registered: " + player);
        } else {
            System.out.println("Player already registered: " + player);
        }
    }

    public void scheduleMatch(Match match) {
        matchQueue.add(match);
        System.out.println("Match scheduled: " + match);
    }

    public void processMatches() {
        System.out.println("\nProcessing matches:");
        while (!matchQueue.isEmpty()) {
            Match match = matchQueue.poll();
            System.out.println("Playing: " + match);
            Result result = new Result(match.toString(), "Player" + (Math.random() > 0.5 ? "1" : "2"));
            results.add(result);
            System.out.println(result);
        }
    }

    public void updateLeaderboard(Score score) {
        leaderboard.add(score);
    }

    public void displayLeaderboard() {
        System.out.println("\nLeaderboard:");
        for (Score score : leaderboard) {
            System.out.println(score);
        }
    }

    public static void main(String[] args) {
        OnlineGamingTournament tournament = new OnlineGamingTournament();

        tournament.registerPlayer(new Player("P001", "Alice"));
        tournament.registerPlayer(new Player("P002", "Bob"));
        tournament.registerPlayer(new Player("P001", "Alice"));

        tournament.scheduleMatch(new Match("M001", "Alice", "Bob"));
        tournament.scheduleMatch(new Match("M002", "Alice", "Charlie"));

        tournament.processMatches();

        tournament.updateLeaderboard(new Score("P001", 100));
        tournament.updateLeaderboard(new Score("P002", 85));
        tournament.updateLeaderboard(new Score("P003", 95));

        tournament.displayLeaderboard();
    }
}
