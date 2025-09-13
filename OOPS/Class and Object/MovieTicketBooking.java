public class MovieTicketBooking {
    private String movieName;
    private String seatNumber;
    private double price;

    public MovieTicketBooking(String movieName) {
        this.movieName = movieName;
        this.seatNumber = null;
        this.price = 0.0;
    }

    public void bookTicket(String seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public void displayTicketDetails() {
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: " + price);
    }
}

class MainMovieTicketBooking {
    public static void main(String[] args) {
        MovieTicketBooking ticket = new MovieTicketBooking("Avengers");
        ticket.bookTicket("A10", 300.0);
        ticket.displayTicketDetails();
    }
}