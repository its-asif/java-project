# java-project
## The features of the Movie Ticket Booking project:
1.	The project allows users to view available movies.
2.	Users can see the seating arrangement in two cinema halls for different time slots.
3.	Users can book seats for a specific movie, hall, row, and column.
4.	The project ensures that a seat can only be booked if it is available.
5.	The system keeps track of the booked seats and marks them as occupied.
6.	Users can exit the system when they are done with their bookings.
Overall, the project provides a simple ticket booking system where users can view available movies, check seating availability, and book seats for their desired movie and time slot.

## Summary of the methods used in the code:
1.	The **Seat** class represents a seat in the cinema. It has a flag to indicate if it's booked or not. It provides methods to book and unbook seats.
2.	The **CinemaHall** class represents a cinema hall with its seating arrangement for different time slots. It has methods to create seats, display available seats, and book seats.
3.	The **Movie** class represents a movie with its details like title, genre, director, duration, and time slot. It provides methods to access movie information.
4.	The **MovieTicketBooking** class is the booking system’s main controller. It manages the available movies and cinema halls. It has methods to display movies, display seats, and book tickets.
5.	The **finalProject** class contains the main method and serves as the entry point. It creates instances of the Scanner class to read user input and the MovieTicketBooking class to start the booking system.

## Summary of the methods used in the code:
1.	**Seat class**:
*	**isBooked()**: Returns whether the seat is booked or not.
*	**bookSeat()**: Marks the seat as booked.
*	**unbookSeat()**: Marks the seat as unbooked.
*	**toString()**: Returns a string representation of the seat.
2.	**CinemaHall class**:
*	**CinemaHall(rows, columns)**: Constructor to create a cinema hall with a given number of rows and columns.
*	**createSeats(rows, columns)**: Creates and returns a 2D array of Seat objects representing the seats in the cinema hall.
*	**displaySeats(timeSlot)**: Displays the seats for a specific time slot.
*	**bookSeat(timeSlot, row, column)**: Books a seat for a specific time slot, row, and column.
3.	**Movie class**:
*	**getTitle()**: Returns the title of the movie.
*	**getGenre()**: Returns the genre of the movie.
*	**getDirector()**: Returns the director of the movie.
*	**getDuration()**: Returns the duration of the movie.
*	**getTimeSlot()**: Returns the time slot of the movie.
4.	**MovieTicketBooking** class:
*	**displayMovies()**: Displays the available movies.
*	**displaySeats(hallNumber, timeSlot)**: Displays the seats for a specific cinema hall and time slot.
*	**bookTicket(hallNumber, row, column, timeSlot)**: Books a ticket for a specific cinema hall, seat, and time slot.
*	**getMovieByNumber(movieNumber)**: Returns the Movie object corresponding to the given movie number.
5.	finalProject class:
*	**main(args)**: The entry point of the program. It displays a menu and handles user input for movie selection, seat booking, and exiting the program.

