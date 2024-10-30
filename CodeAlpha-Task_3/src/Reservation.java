import java.util.Date;

public class Reservation {
    private int reservationId;
    private Room room;
    private String guestName;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(int reservationId, Room room, String guestName, Date checkInDate, Date checkOutDate) {
        this.reservationId = reservationId;
        this.room = room;
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public int getReservationId() {
        return reservationId;
    }

    public Room getRoom() {
        return room;
    }

    public String getGuestName() {
        return guestName;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId + ", Guest Name: " + guestName +
                ", Room ID: " + room.getRoomId() + ", Check-in: " + checkInDate + ", Check-out: " + checkOutDate;
    }
}

