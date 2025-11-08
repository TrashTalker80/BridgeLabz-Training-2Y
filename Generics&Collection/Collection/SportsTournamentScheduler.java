import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

class Team implements Comparable<Team> {
    private String teamId;
    private String name;
    private int points;

    public Team(String teamId, String name, int points) {
        this.teamId = teamId;
        this.name = name;
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(teamId, team.teamId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId);
    }

    @Override
    public int compareTo(Team other) {
        return Integer.compare(other.points, this.points);
    }

    @Override
    public String toString() {
        return teamId + " - " + name + " (" + points + " points)";
    }
}

class MatchFixture {
    private String matchId;
    private String team1;
    private String team2;

    public MatchFixture(String matchId, String team1, String team2) {
        this.matchId = matchId;
        this.team1 = team1;
        this.team2 = team2;
    }

    @Override
    public String toString() {
        return matchId + ": " + team1 + " vs " + team2;
    }
}

class MatchResult {
    private String matchId;
    private String winner;

    public MatchResult(String matchId, String winner) {
        this.matchId = matchId;
        this.winner = winner;
    }

    @Override
    public String toString() {
        return matchId + " - Winner: " + winner;
    }
}

public class SportsTournamentScheduler {
    private Set<Team> teams;
    private Queue<MatchFixture> matchSchedule;
    private List<MatchResult> results;
    private TreeSet<Team> leaderboard;

    public SportsTournamentScheduler() {
        teams = new HashSet<>();
        matchSchedule = new LinkedList<>();
        results = new ArrayList<>();
        leaderboard = new TreeSet<>();
    }

    public void registerTeam(Team team) {
        if (teams.add(team)) {
            System.out.println("Team registered: " + team);
        } else {
            System.out.println("Team already registered: " + team);
        }
    }

    public void scheduleMatch(MatchFixture match) {
        matchSchedule.add(match);
        System.out.println("Match scheduled: " + match);
    }

    public void processMatches() {
        System.out.println("\nProcessing matches:");
        while (!matchSchedule.isEmpty()) {
            MatchFixture match = matchSchedule.poll();
            System.out.println("Playing: " + match);
            MatchResult result = new MatchResult(match.toString(), "Team" + (Math.random() > 0.5 ? "1" : "2"));
            results.add(result);
            System.out.println(result);
        }
    }

    public void updateLeaderboard(Team team) {
        leaderboard.add(team);
    }

    public void displayLeaderboard() {
        System.out.println("\nLeaderboard:");
        for (Team team : leaderboard) {
            System.out.println(team);
        }
    }

    public static void main(String[] args) {
        SportsTournamentScheduler tournament = new SportsTournamentScheduler();

        tournament.registerTeam(new Team("T001", "Team Alpha", 0));
        tournament.registerTeam(new Team("T002", "Team Beta", 0));
        tournament.registerTeam(new Team("T001", "Team Alpha", 0));

        tournament.scheduleMatch(new MatchFixture("M001", "Team Alpha", "Team Beta"));
        tournament.scheduleMatch(new MatchFixture("M002", "Team Gamma", "Team Delta"));

        tournament.processMatches();

        tournament.updateLeaderboard(new Team("T001", "Team Alpha", 6));
        tournament.updateLeaderboard(new Team("T002", "Team Beta", 3));
        tournament.updateLeaderboard(new Team("T003", "Team Gamma", 9));

        tournament.displayLeaderboard();
    }
}
