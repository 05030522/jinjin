package Hotel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
public class Hotel {
    private float asset;
    private LinkedHashMap<Room, Boolean> rooms;
    private HashMap<String, Reservation> reservations;
    public Hotel() {
        asset = 0f;
        rooms = initRooms();
        reservations = new HashMap<>();
    }
    private LinkedHashMap<Room, Boolean> initRooms() {
        LinkedHashMap<Room, Boolean> rooms = new LinkedHashMap<>();
        rooms.put(new Room("1", "Single", 100f), false);
        rooms.put(new Room("2", "Single", 100f), false);
        rooms.put(new Room("3", "Single", 100f), false);
        rooms.put(new Room("4", "Double", 180f), false);
        rooms.put(new Room("5", "Double", 180f), false);
        rooms.put(new Room("6", "Double", 180f), false);
        rooms.put(new Room("7", "Double", 180f), false);
        rooms.put(new Room("8", "Family", 320f), false);
        rooms.put(new Room("9", "Family", 320f), false);
        rooms.put(new Room("10", "Family", 320f), false);
        rooms.put(new Room("11", "Family", 320f), false);
        rooms.put(new Room("12", "Premium", 750f), false);
        rooms.put(new Room("13", "Premium", 750f), false);
        rooms.put(new Room("14", "Premium", 750f), false);
        rooms.put(new Room("15", "Superior", 1250f), false);
        return rooms;
    }
    public float getAsset() {
        return asset;
    }  //미사용
    public void addAsset(float asset) {
        this.asset += asset;
    }
    public void subAsset(float asset) {
        this.asset -= asset;
    }
    public HashMap<Room, Boolean> getRooms() {
        return rooms;
    }  //미사용
    public void addRoom(Room room) {
        rooms.put(room, false);
    }  //미사용
    public ArrayList<Room> displayAllRooms() {
        // 사용 중이지 않은 room들을 담을 ArrayList<Room>을 새로 정의한다.
        ArrayList<Room> roomList = new ArrayList<>();
        LinkedHashMap<Room, Boolean> map = initRooms();
        // rooms (Room 타입의 객실 Map)를 keySet()을 통한 for문을 통해 room을 하나씩 불러오고
        for (Room room : rooms.keySet()) {
            if (!rooms.get(room)) {
                System.out.println(
                        String.format("Room번호: %s | Room크기: %s | 가격: %s "
                                , room.getRoom_id()
                                , room.getSize()
                                , room.getPrice())
                );
                roomList.add(room);
            }
        }
        return roomList;
    }
    // 1. 예약하기 -- 객실 예약 확정 (구현)
    public void bookRoom(Room room) {
        // 객실의 상태를 '사용중(true)'로 변경
        rooms.replace(room, true);
        // 호텔 보유 자산을 예약된 방 가격만큼 증가시킴
//        asset += room.getPrice();
    }
    // 3. 예약 취소하기 -- 객실 예약 취소 (구현)
    public void cancelRoom(Room room) {  //미사용
        // 객실의 상태를 '사용 안함(false)'로 변경
        rooms.replace(room, false);
        // 호텔 보유 자산을 예약된 방 가격만큼 감소시킴
        asset -= room.getPrice();
    }
    // 1. 예약 확인하기 -- 예약 목록에 예약 정보 추가 (구현)
    public void addReservation(String uuid, Reservation reservation){  //미사용
        // 예약 목록(reservations)에 uuid를 키로 reservation 삽입
    }
    // 3. 예약 취소하기 -- 예약 목록에서 예약 정보 제거 (구현)
    public void removeReservation(String uuid){  //미사용
        // 예약 목록(reservations)에서 uuid를 키로 reservation 삽입
    }
    public void displayAllReservations() {  //미사용
        for (String key : reservations.keySet()) {
            reservations.get(key).toString();
        }
    }
}
