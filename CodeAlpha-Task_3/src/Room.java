public class Room {
    private int roomId;
    private String category;
    private double price;
    private boolean isAvailable;

    public Room(int roomId, String category, double price) {
        this.roomId = roomId;
        this.category = category;
        this.price = price;
        this.isAvailable = true;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Room ID: " + roomId + ", Category: " + category + ", Price: $" + price + ", Available: " + isAvailable;
    }
}

