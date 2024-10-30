import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        // Adding some rooms to the hotel for demonstration
        hotel.addRoom(new Room(101, "Standard", 100.0));
        hotel.addRoom(new Room(102, "Standard", 100.0));
        hotel.addRoom(new Room(201, "Deluxe", 150.0));
        hotel.addRoom(new Room(202, "Deluxe", 150.0));
        hotel.addRoom(new Room(301, "Suite", 200.0));

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. Search for rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter room category to search (Standard/Deluxe/Suite): ");
                    String category = scanner.nextLine();
                    List<Room> availableRooms = hotel.searchRooms(category);
                    System.out.println("Available Rooms:");
                    availableRooms.forEach(System.out::println);
                }
                case 2 -> {
                    System.out.print("Enter room ID to reserve: ");
                    int roomId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Room room = hotel.searchRooms("Standard").stream()
                            .filter(r -> r.getRoomId() == roomId)
                            .findFirst()
                            .orElse(null);

                    if (room == null || !room.isAvailable()) {
                        System.out.println("Room not available or invalid room ID.");
                        continue;
                    }

                    System.out.print("Enter guest name: ");
                    String guestName = scanner.nextLine();
                    System.out.print("Enter check-in date (dd-MM-yyyy): ");
                    Date checkInDate = sdf.parse(scanner.nextLine());
                    System.out.print("Enter check-out date (dd-MM-yyyy): ");
                    Date checkOutDate = sdf.parse(scanner.nextLine());

                    Reservation reservation = hotel.makeReservation(room, guestName, checkInDate, checkOutDate);
                    if (reservation != null) {
                        System.out.println("Reservation successful:\n" + reservation);
                    }
                }
                case 3 -> {
                    System.out.println("Current Reservations:");
                    hotel.getReservations().forEach(System.out::println);
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option, please try again.");
            }
        }
    }
}

