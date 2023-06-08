package Hotel;
import java.util.Scanner;
public class Reservation {
    private Room room; //방 정보
    private String name; //예약자 이름
    private String phoneNum; //예약자 전번
    private String date; //예약할 날짜(예약일)
    // 예약시 방이름, 예약자, 전번, 예약일
    public Reservation(Room room, String name, String phoneNum) {
        this.room = room;
        this.name = name;
        this.phoneNum = phoneNum;
        this.date = inDate(0, 0, 0);
    }
    public String inDate(int YYdate, int MMdate, int DDdate){
        Scanner in = new Scanner(System.in);
        System.out.println("예약하실 년도를 알려주세요.");
        System.out.println("[예시 2023년 -> 2023 ]");
        System.out.print("년 입력 : ");
        YYdate = in.nextInt();
        System.out.println("예약하실 달을 알려주세요.");
        System.out.println("[예시 5월 -> 05 ]");
        System.out.print("달 입력 : ");
        MMdate = in.nextInt();
        System.out.println("예약하실 일을 알려주세요.");
        System.out.println("[예시 28일 -> 28 ]");
        System.out.print("일 입력 : ");
        DDdate = in.nextInt();
        String date = YYdate + "-" + MMdate + "-" + DDdate;
        return date;
    }
    public String getRoom(String Room){
        return Room;
    }  //방이름 가져오기 미사용
    public String getName(String Name){
        return Name;
    } //예약자 가져오기 미사용
    public String getPhoneNum(String PhoneNum) {
        return PhoneNum;
    } // 전번 가져오기 미사용
    public String getReservedInfo(){ //미사용
        return String.format("Room_id: %s | Room_size: %s | Room_price: %s | Name: %s | Phone_number: %s | Reserved_date: %s", room.getRoom_id(), room.getSize(), room.getPrice(), name, phoneNum, date);
    }
    public String getDate() {
        return date;
    } //미사용
    public String toString() {
        return "Room_id: " + room.getRoom_id() +
                " | Room_size: " + room.getSize() +
                " | Room_price: " + Float.toString(room.getPrice()) +
                " | name: " + name +
                " | phoneNum: " + phoneNum +
                " | date: " + date;
    }
}
