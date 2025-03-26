import java.util.HashSet;
import java.util.Set;

class SeatAlreadyBookedException extends Exception {
    public SeatAlreadyBookedException(String message) {
        super(message);
    }
}

class MovieTicketBooking {
    private Set<Integer> bookedSeats = new HashSet<>();

    public void bookSeat(int seatNumber) throws SeatAlreadyBookedException {
        if (bookedSeats.contains(seatNumber)) {
            throw new SeatAlreadyBookedException("Error: Seat " + seatNumber + " is already booked.");
        }
        bookedSeats.add(seatNumber);
        System.out.println("Seat " + seatNumber + " booked successfully.");
    }
}

public class EXP8Q5 {
    public static void main(String[] args) {
        MovieTicketBooking bookingSystem = new MovieTicketBooking();
        int seatToBook = 10;

        try {
            bookingSystem.bookSeat(seatToBook);
            bookingSystem.bookSeat(seatToBook); 
        } catch (SeatAlreadyBookedException e) {
            System.out.println(e.getMessage());
        }
    }
}
