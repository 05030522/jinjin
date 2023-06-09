package Hotel;

import Hotel.Reservation;
import Hotel.Room;

import javax.naming.Name;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Pattern;

import static java.lang.System.*;


public class Home {
    //날짜는 인데이터 메소드를 이용함

    private Hotel hotel;
    private List<Customer> customers; // 고객 목록
    private Scanner sc;

    public Home() {
        hotel = new Hotel();
        customers = new ArrayList<>();
        sc = new Scanner(in);
    }

    public void dateReservation(Customer customer)  {
        Reservation reservation = new Reservation(null, null, null);
        Room room = new Room(null, null, 0.0f);
        String name = customer.getName();
        String phoneNum = customer.getPhoneNum();
//        String date = reservation.inDate(0,0,0);
        List<Reservation> reservationList = new ArrayList<>();
        reservationList.add(reservation);
    }
    public void start()  {
        while (true) {
            Customer customer = registerCustomer(); //고객 등록을 진행

            out.println("-----------------------");
            boolean login = true;
            while (login) {
                int choice = displayOptions();
                switch (choice) {
                    // 예약하기
                    case 1:
                        dateReservation(customer);

                        makeReservation(customer);
                        break;

                    // 예약 확인
                    case 2:
                        checkReservation();
                        break;

                    // 예약 취소
                    case 3:
                        cancelReservation();
                        break;

                    // 나가기
                    case 4:
                        login = false;
                        break;
                }
            }
            out.println("-----------------------");
        }

    }
    public Customer registerCustomer() {
        out.println("[Hotel 로그인 화면]");
        String name = askName();
        String phoneNum = askPhoneNum();
        float wallet = askWallet();
        sc.nextLine();

        Customer customer = new Customer(name, phoneNum, wallet);
        customers.add(customer);
        return customer;
    }

    public String askName() {
        out.print("이름 : ");
        return sc.nextLine();
    }

    public String askPhoneNum() {
        out.print("전화번호 (ex. 012-3456-7890): ");
        String phoneNum = sc.nextLine();

        String regex_phoneNum = "^01([0|1|6|7|8|9])-?([0-9]{4})-?([0-9]{4})$";
        while (!Pattern.matches(regex_phoneNum, phoneNum)) {
            out.println("전화번호의 형식이 일치하지 않습니다. 다시 입력해주세요.");
            out.print("전화번호 (ex. 012-3456-7890): ");
            phoneNum = sc.nextLine();
        }
        return phoneNum;
    }

    public float askWallet() {
        out.print("얼마를 소지하고 계신가요? :");
        return sc.nextFloat();
    }

    public int displayOptions() {
        out.println("Hotel에 오신걸 환영합니다.");
        out.println("1. 예약하기 \t2. 예약 확인\t3. 예약 취소\t4. 나가기");

        int choice;
        out.print("번호를 입력하세요 : ");
        while ((choice = sc.nextInt()) > 4) {
            out.println("유효하지 않은 번호입니다.");
            out.print("번호를 입력하세요 : ");
        }
        sc.nextLine();
        return choice;
    }

    public void makeReservation(Customer customer) {

        // Hotel이 보유한 객실 출력 -- 이미 예약된 객실은 제외
        Hotel hotel = new Hotel();
        ArrayList<Room> rooms = hotel.displayAllRooms();

        // 객실 선택 -- 객실 번호를 제대로 입력할 때까지 반복

        Scanner sc = new Scanner(System.in);
        Room targetRoom = null;
        while (targetRoom == null) {
            System.out.print("\n");
            System.out.print("객실 번호를 입력해주세요 : ");
            int num = sc.nextInt();
            if (1 <= num && num <= 15) {
                for (Room room : rooms) {
                    if (room.getRoom_id().equals(String.valueOf(num))) {
                        targetRoom = room;
                        System.out.print("\n");
                        System.out.println("선택한 객실 정보: " + room);
                        break;
                    }
                }
            } else if (num >= 0 || num >= 16) {
                System.out.print("\n");
                System.out.print("존재하지 않는 객실 번호입니다.");
                System.out.print("객실 번호를 다시 입력해주세요 : ");

                int num2 = sc.nextInt();
                for (Room room : rooms) {
                    if (room.getRoom_id().equals(String.valueOf(num2))) {
                        targetRoom = room;
                        System.out.print("\n");
                        System.out.println("선택한 객실 정보: " + room);
                        break;
                    }
                }
            }
        }
        if (customer.getWallet()>= targetRoom.getPrice()) {
            System.out.println("예약이 확인되었습니다.");
            hotel.addAsset(targetRoom.getPrice());
            customer.subWallet(targetRoom.getPrice());
            hotel.bookRoom(targetRoom);
            String uuid = UUID.randomUUID().toString();
            targetRoom.setUuid(uuid);
//            해당 객실을 예약 상태로 바꾸고 예약 번호(id <- uuid) 생성
        }else if (customer.getWallet() < targetRoom.getPrice()){
            out.println("소지금이 부족합니둥~ 돈 벌어오3!");
            hotel.subAsset(targetRoom.getPrice());
            customer.addWallet(targetRoom.getPrice());
        }
        // Reservation을 생성 후 Hotel과 Customer의 예약 목록에 각각 추가

        System.out.print("\n");
        out.println("예약이 완료되었습니다.");
        System.out.print("\n");
    }
                public void checkReservation () {
                    Hotel hotel = new Hotel();
                    System.out.print("\n");
                    System.out.println("--------------------------------------");
                    System.out.print("[ 예약 내역 ]");
                    hotel.displayAllReservations();
                }


                public void cancelReservation () {
                    // 고객의 예약 목록(List<Reservation>) 불러오기
                    Hotel hotel = new Hotel();
                    Customer customer = new Customer(null, null, 0.0f);
                    System.out.print("\n");
                    System.out.println("--------------------------------------");
                    System.out.print("[ 예약 내역 ]");
                    hotel.displayAllReservations();
                    // 예약 번호(id) 입력 후 예약 목록에서 해당 예약 정보 삭제하기
                    System.out.print("\n");
                    System.out.println("--------------------------------------");
                    out.print("취소할 예약건의 ID를 입력해주세요 : ");
                    Scanner id = new Scanner(System.in);
                    Room room = new Room(null, null, 0.0f);
                    String inputId = id.nextLine();
                    Room targetRoom = room;
                    String uuid = targetRoom.getUuid();
                    if (inputId.equals(uuid)) {
                        hotel.removeReservation(inputId);
                    }
                    // 객실의 상태를 예약 가능으로 바꾸고, 호텔의 보유자산을 객실 가격 만큼 빼고, 고객의 소지금에 다시 추가한다
                }
            }