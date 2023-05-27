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
            return " X ";
        } else {
            return " * ";
        }
    }
}

class CinemaHall {
    private Seat[][] seats;

    public CinemaHall(int rows, int columns) {
        seats = new Seat[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i][j] = new Seat();
            }
        }
    }

    public void displaySeats() {
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                System.out.print(seat.toString() + " ");
            }
            System.out.println();
        }
    }

    public boolean bookSeat(int row, int column) {
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

public class finalProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CinemaHall hall1 = new CinemaHall(5, 4);
        CinemaHall hall2 = new CinemaHall(5, 4);

        System.out.println("Welcome to the Cinema Ticket Management System!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Display available seats");
            System.out.println("2. Book a seat");
            System.out.println("3. Exit");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("\nHall 1:");
                    hall1.displaySeats();
                    System.out.println("\nHall 2:");
                    hall2.displaySeats();
                    break;
                case 2:
                    System.out.println("Enter the hall number (1 or 2):");
                    int hallNumber = scanner.nextInt();
                    System.out.println("Enter the row number (1-5):");
                    int rowNumber = scanner.nextInt();
                    System.out.println("Enter the column number (1-4):");
                    int columnNumber = scanner.nextInt();

                    CinemaHall selectedHall;
                    if (hallNumber == 1) {
                        selectedHall = hall1;
                    } else if (hallNumber == 2) {
                        selectedHall = hall2;
                    } else {
                        System.out.println("Invalid hall number!");
                        break;
                    }

                    if (selectedHall.bookSeat(rowNumber, columnNumber)) {
                        System.out.println("Seat booked successfully!");
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using the Cinema Ticket Management System!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}
