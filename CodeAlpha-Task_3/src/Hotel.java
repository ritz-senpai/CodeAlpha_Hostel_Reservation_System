import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    private List<Room> rooms;
    private List<Reservation> reservations;
    private int nextReservationId = 1;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> searchRooms(String category) {
        return rooms.stream()
                .filter(room -> room.isAvailable() && room.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public Reservation makeReservation(Room room, String guestName, Date checkInDate, Date checkOutDate) {
        if (room.isAvailable()) {
            room.setAvailable(false);
            Reservation reservation = new Reservation(nextReservationId++, room, guestName, checkInDate, checkOutDate);
            reservations.add(reservation);
            System.out.println("Payment processed successfully for $" + room.getPrice());
            return reservation;
        } else {
            System.out.println("Room is not available.");
            return null;
        }
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}

