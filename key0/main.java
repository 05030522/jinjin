package key0;
import java.util.ArrayList;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Menus myMenu = new Menus();
        ArrayList<Menu> mainItems = myMenu.getMainItems();
        ArrayList<Menu> subItems = myMenu.getSubItems();
        ArrayList<Menu> beverageItems = myMenu.getBeverageItems();
        goods myGoods = new goods();
        int menuNumber = 0;
        ArrayList<Menu> selectMenu = new ArrayList<>();
        Scanner scanner;
        boolean repeatMain = true;
        int a = 1;
        scanner = new Scanner(System.in);
        while (repeatMain) {
            System.out.println("[Code_BurGer의 세계에 당도하신 것을 환영합니다!]");
            System.out.println("아래의 메뉴판을 보고 메뉴를 골라 입력해주세요.");
            System.out.print("\n");
            System.out.println("1. [CBG MAIN MENU]  |  코드버거가 엄선한 최고의 햄버거 군단들!");
            System.out.println("2. [CBG SUB MENU]  |  햄버거로는 배가 안찰때 최고의 선택!");
            System.out.println("3. [CBG BEVERAGE MENU]  |  음료수 같이 안사면 후회합니다. 1회 리필가능!");
            System.out.print("\n");
            System.out.println("[ORDER MENU]");
            System.out.println("4.Order  |  장바구니를 확인 후 주문합니다.");
            System.out.println("5.Cancel  |  진행중인 주문을 취소합니다.");
            System.out.print("번호를 입력해주세요 : ");
            int numberss = scanner.nextInt();
            System.out.print("\n");
            if (numberss == 1) {
                System.out.println("[CBG MAIN MENU]");
                int i = 1;
                for (Menu item : mainItems) {
                    System.out.println(i + ". " + item.name + "  |  " + myGoods.getMainPrice(i - 1) + "원" + "  |  " + item.desc);
                    i++;}
                System.out.print("\n");
            } else if (numberss == 2) {
                System.out.println("[CBG SUB MENU]");
                int j = 6;
                for (Menu item : subItems) {
                    System.out.println(j + ". " + item.name + "  |  " + myGoods.getSubPrice(j - 6) + "원" + "  |  " + item.desc);
                    j++;}
                System.out.print("\n");
            } else if (numberss == 3) {
                System.out.println("[CBG BEVERAGE MENU]");
                int k = 11;
                for (Menu item : beverageItems) {
                    System.out.println(k + ". " + item.name + "  |  " + myGoods.getBeveragePrice(k - 11) + "원" + "  |  " + item.desc);
                    k++;}
                System.out.print("\n");
            } else if (numberss == 4) {
                System.out.println("[ Order ]");
                    for (Menu selectMenus : selectMenu) {
                        System.out.println(selectMenus.name + "  |  " + selectMenus.price + "원  |  " + selectMenus.desc);}
                    System.out.print("\n");
                    System.out.println("[ Total ]");
                    int totalPrice = 0;
                    for (Menu selectMenus : selectMenu) {
                        totalPrice += selectMenus.price;}
                        System.out.println(totalPrice + "원");
                    System.out.print("\n");
                    System.out.println("1.주문\t\t\t2.메뉴판");
                    System.out.print("입력해주세요 : ");
                    int number7 = scanner.nextInt();
                        if(number7==1){
                            System.out.println("주문이 완료되었습니다!");
                            System.out.print("\n");
                            System.out.println("대기번호는 [ " + a + " ] 번 입니다.");
                            System.out.println("(메뉴판으로 돌아갑니다.)");
                            selectMenu.clear();
                            System.out.print("\n");
                            a++;
                            continue;
                        } else if (number7==2) {
                            continue;}
            } else if (numberss==5) {
                System.out.println("주문을 취소하였습니다.");
                selectMenu.clear();
                continue;
            } else {
                System.out.println("잘못된 번호를 입력하셨습니다.");
                continue;}
            System.out.print("주문할 상품의 번호를 입력해주세요 : ");
            int number1 = scanner.nextInt();
            System.out.print("\n");
            System.out.print("---------------------------------------------------------------------------------");
            System.out.print("\n");
            if (1 <= number1 || number1 <= 15) {
                if (number1 >= 1 && number1 <= mainItems.size()) {
                    Menu item = mainItems.get(number1 - 1);
                    System.out.println(item.name + " | " + myGoods.getMainPrice(number1 - 1) + "원" + " | " + item.desc);
                } else if (number1 >= 6 && number1 <= 6 + subItems.size() - 1) {
                    Menu item = subItems.get(number1 - 6);
                    System.out.println(item.name + " | " + myGoods.getSubPrice(number1 - 6) + "원" + " | " + item.desc);
                } else if (number1 >= 11 && number1 <= 11 + beverageItems.size() - 1) {
                    Menu item = beverageItems.get(number1 - 11);
                    System.out.println(item.name + " | " + myGoods.getBeveragePrice(number1 - 11) + "원" + " | " + item.desc);
                } else if (number1 >= 16 && number1 <= -1) {
                    System.out.println("잘못된 메뉴번호입니다. 메뉴화면으로 돌아갑니다.");
                    continue;}
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.print("\n");
                System.out.println("1.확인\t\t\t2.취소");
                System.out.print("입력하기 : ");
                int numbers = scanner.nextInt();
                System.out.print("\n");
                Menu item = null;
                int price = 0;
                if (numbers == 1) {
                    if (number1 >= 1 && number1 <= mainItems.size()) {
                        item = mainItems.get(number1 - 1);
                        price = myGoods.getMainPrice(number1 - 1);
                    } else if (number1 >= 6 && number1 <= 6 + subItems.size() - 1) {
                        item = subItems.get(number1 - 6);
                        price = myGoods.getSubPrice(number1 - 6);
                    } else if (number1 >= 11 && number1 <= 11 + beverageItems.size() - 1) {
                        item = beverageItems.get(number1 - 11);
                        price = myGoods.getBeveragePrice(number1 - 11);}
                    item.price = price;
                    System.out.println(item.name + "가 장바구니에 추가되었습니다.");
                    selectMenu.add(item);
                    System.out.print("\n");}
                if (numbers == 2) {
                    System.out.println("제품 선택이 취소되었습니다.");
                    System.out.print("\n");
                    continue;}}}}}