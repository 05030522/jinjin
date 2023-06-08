package Hotel;
public class Room {
    private String roomID;
    private String size;
    private float price;
    Room(String roomID, String size, float price) {
        this.roomID = roomID;
        this.size = size;
        this.price = price;
    }
    private String uuid;
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getRoom_id() {
        return roomID;
    }
    public String getSize() {
        return size;
    }
    public float getPrice() {
        return price;
    }
    public String toString() {
        return String.format("Room_ID: %2s | Room_size: %-9s | Room_price: %s", roomID, size, price);
    }
}