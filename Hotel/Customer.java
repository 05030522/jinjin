package Hotel;
import java.util.HashMap;
public class Customer {
    private String name;
    private String phoneNum;
    private float wallet;
    private HashMap<String, Reservation>reservations; // 고객 예약 목록 key = uuid, value = Reservation
    public Customer(String name, String phoneNum, float wallet) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.wallet = wallet;
        this.reservations = new HashMap<>();
    }
    public String getName() {
        return name;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public float getWallet() {
        return wallet;
    }
    public void addWallet(float wallet) {
        this.wallet += wallet;
    }
    public void subWallet(float wallet) {
        this.wallet -= wallet;
    }
    public HashMap<String, Reservation> getReservations() { return reservations; }  //미사용
    public void setWallet(float wallet) {  //미사용
        this.wallet = wallet;
    }
    public void addReservation(String uuid, Reservation reservation){  //미사용
        reservations.put(uuid, reservation);
    }
    // 2. 예약 확인하기 -- 고객의 예약 정보 전부 출력하기 (구현)
    public void displayReservations() {  //미사용
        // HashMap인 reservations의 요소 하나하나를 keySet()을 통한 for문
        // 혹은 entrySet()을 이용한 stream()으로 출력한다.
    }
}