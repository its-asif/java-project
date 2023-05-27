import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Seat {
    private boolean isBooked;

    public Seat() {
        isBooked = false;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookSeat() {
        isBooked = true;
    }

    public void unbookSeat() {
        isBooked = false;
    }

    @Override
    public String toString() {
        if (isBooked) {
            return "X";
        } else {
            return ".";
        }
    }
}

class CinemaHall {
    private Map<String, Seat[][]> seatsByTimeSlot;

    public CinemaHall(int rows, int columns) {
        seatsByTimeSlot = new HashMap<>();
        seatsByTimeSlot.put("10:00 AM", createSeats(rows, columns));
        seatsByTimeSlot.put("1:30 PM", createSeats(rows, columns));
        seatsByTimeSlot.put("4:00 PM", createSeats(rows, columns));
    }

    private Seat[][] createSeats(int rows, int columns) {
        Seat[][] seats = new Seat[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i][j] = new Seat();
            }
        }
        return seats;
    }

    public void displaySeats(String timeSlot) {
        Seat[][] seats = seatsByTimeSlot.get(timeSlot);
        if (seats == null) {
            System.out.println("Invalid time slot!");
            return;
        }

        System.out.println("Seats for " + timeSlot + ":");
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                System.out.print(seat.toString() + " ");
            }
            System.out.println();
        }
    }

    public boolean bookSeat(String timeSlot, int row, int column) {
        Seat[][] seats = seatsByTimeSlot.get(timeSlot);
        if (seats == null) {
            System.out.println("Invalid time slot!");
            return false;
        }

        if (row < 1 || row > seats.length || column < 1 || column > seats[0].length) {
            System.out.println("Invalid seat selection!");
            return false;
        }

        Seat selectedSeat = seats[row - 1][column - 1];
        if (selectedSeat.isBooked()) {
            System.out.println("Seat already booked!");
            return false;
        }

        selectedSeat.bookSeat();
        return true;
    }
}

class Movie {
    private String title;
    private String genre;
    private String director;
    private int duration;
    private String timeSlot;

    public Movie(String title, String genre, String director, int duration, String timeSlot) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.duration = duration;
        this.timeSlot = timeSlot;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public int getDuration() {
        return duration;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    @Override
    public String toString() {
        return title + " (" + timeSlot + ")";
    }
}

class MovieTicketBooking {
    private Movie[] movies;
    private CinemaHall hall1;
    private CinemaHall hall2;

    public MovieTicketBooking() {
        movies = new Movie[3];
        movies[0] = new Movie("The Avengers", "Action", "Joss Whedon", 143, "10:00 AM");
        movies[1] = new Movie("Inception", "Sci-Fi", "Christopher Nolan", 148, "1:30 PM");
        movies[2] = new Movie("The Lion King", "Animation", "Jon Favreau", 118, "4:00 PM");

        hall1 = new CinemaHall(5, 4);
        hall2 = new CinemaHall(5, 4);
    }

    public void displayMovies() {
        System.out.println("Available Movies:");
        for (int i = 0; i < movies.length; i++) {
            System.out.println((i + 1) + ". " + movies[i]);
        }
    }

    public void displaySeats(int hallNumber, String timeSlot) {
        CinemaHall selectedHall;
        if (hallNumber == 1) {
            selectedHall = hall1;
        } else if (hallNumber == 2) {
            selectedHall = hall2;
        } else {
            System.out.println("Invalid hall number!");
            return;
        }

        selectedHall.displaySeats(timeSlot);
    }

    public void bookTicket(int hallNumber, int row, int column, String timeSlot) {
        CinemaHall selectedHall;
        if (hallNumber == 1) {
            selectedHall = hall1;
        } else if (hallNumber == 2) {
            selectedHall = hall2;
        } else {
            System.out.println("Invalid hall number!");
            return;
        }

        Movie selectedMovie = null;
        for (Movie movie : movies) {
            if (movie.getTimeSlot().equals(timeSlot)) {
                selectedMovie = movie;
                break;
            }
        }

        if (selectedMovie == null) {
            System.out.println("Invalid time slot selection!");
            return;
        }

        System.out.println("You selected the movie: " + selectedMovie.getTitle());

        if (selectedHall.bookSeat(timeSlot, row, column)) {
            System.out.println("Seat booked successfully!");
        }
    }

    public Movie getMovieByNumber(int movieNumber) {
        if (movieNumber >= 1 && movieNumber <= movies.length) {
            return movies[movieNumber - 1];
        }
        return null;
    }
}

public class finalProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieTicketBooking ticketBooking = new MovieTicketBooking();

        System.out.println("Welcome to the Cinema Ticket Booking System!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Display available movies");
            System.out.println("2. Display available seats");
            System.out.println("3. Book a seat");
            System.out.println("4. Exit");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    ticketBooking.displayMovies();
                    break;
                case 2:
                    System.out.println("Enter the hall number (1 or 2):");
                    int hallNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    System.out.println("Enter the movie number:");
                    ticketBooking.displayMovies();
                    int movieNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    Movie selectedMovie = ticketBooking.getMovieByNumber(movieNumber);
                    if (selectedMovie == null) {
                        System.out.println("Invalid movie selection!");
                        break;
                    }

                    ticketBooking.displaySeats(hallNumber, selectedMovie.getTimeSlot());
                    break;
                case 3:
                    System.out.println("Enter the hall number (1 or 2):");
                    hallNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    System.out.println("Enter the row number (1-5):");
                    int rowNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    System.out.println("Enter the column number (1-4):");
                    int columnNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    System.out.println("Enter the movie number:");
                    ticketBooking.displayMovies();
                    movieNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    selectedMovie = ticketBooking.getMovieByNumber(movieNumber);
                    if (selectedMovie == null) {
                        System.out.println("Invalid movie selection!");
                        break;
                    }

                    ticketBooking.bookTicket(hallNumber, rowNumber, columnNumber, selectedMovie.getTimeSlot());
                    break;
                case 4:
                    System.out.println("Thank you for using the Cinema Ticket Booking System!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }
        }
    }
}
