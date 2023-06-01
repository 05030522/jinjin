package key0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
class Menu {
    String name;
    String desc;
    double price;
    public Menu(String name, String desc) {
        this.name = name;
        this.desc = desc;}}
class Menus {
    ArrayList<Menu> items;
    Map<String, ArrayList<Menu>> map;
    public Menus() {
        items = new ArrayList<Menu>();
        map = new HashMap<>();
        ArrayList<Menu> mainItems = new ArrayList<>();
        mainItems.add(new Menu("기네스와퍼", "기네스번과 기네스 바베큐 소스의 압도적인 풍미"));
        mainItems.add(new Menu("몬스터와퍼", "불맛 가득 순쇠고기, 치킨, 베이컨에 화끈한 디아블로 소스의 압도적인 맛"));
        mainItems.add(new Menu("콰트로치즈와퍼", "4가지 치즈가 불맛에 녹아들어 계속되는 꽉 들어찬 맛"));
        mainItems.add(new Menu("트리플머쉬룸와퍼", "트러플 크림소스와 네 가지 머쉬룸이 선사하는 깊고 풍부한 맛의 향연"));
        mainItems.add(new Menu("통새우와퍼", "탱글한 통새우, 스파이시 토마토 소스의 조화 새우의 자존심을 세우다"));
        map.put("main", mainItems);
        ArrayList<Menu> subItems = new ArrayList<>();
        subItems.add(new Menu("너겟킹 8조각", "바삭~ 촉촉~ 한입에 쏙 부드러운 너겟킹"));
        subItems.add(new Menu("치즈프라이", "바싹한 프렌치프라이에 고소한 치즈가 듬뿍!"));
        subItems.add(new Menu("크리미모짜볼", "겉은 바삭 속은 부드러운 달콤짭짤 크림치즈"));
        subItems.add(new Menu("치즈스틱", "치즈가 쭈욱 늘어나는 21cm 초대형 치즈스틱"));
        subItems.add(new Menu("코코넛쉬림프", "통통한 통새우에 바삭하고 고소한 코코넛 식감을 더하다"));
        map.put("sub", subItems);
        ArrayList<Menu> beverageItems = new ArrayList<>();
        beverageItems.add(new Menu("제로콜라R", "햄버거를 피할수 없다면 콜라로 죄책감을 덜자"));
        beverageItems.add(new Menu("아메리카노", "아아를 한잔도 마시지 않고 살 수 있는 현대인이 있나요?"));
        beverageItems.add(new Menu("환타오렌지R", "탄산이 필요한 순간! 시원하게 마시자!"));
        beverageItems.add(new Menu("핫초코", "겨울에 따뜻하고 달달한 핫초코 한잔 할래용~?"));
        beverageItems.add(new Menu("미닛메이드", "항상 버거킹에 있는 과일 음료수 미닛메이드 오렌지"));
        map.put("beverage", beverageItems);}
    public void addItem(Menu item) {
        items.add(item);}
    public ArrayList<Menu> getItems() {
        return items;}
    public void showMenus() {
        for (Menu item : items){
            System.out.printf("%-10s | %s\n", item.name, item.desc);}}
    public ArrayList<Menu> getMainItems() {
        return map.get("main");}
    public ArrayList<Menu> getSubItems() {
        return map.get("sub");
    }
    public ArrayList<Menu> getBeverageItems() {
        return map.get("beverage");}
    public static void main(String[] args) {
        Menus myMenu = new Menus();
        myMenu.addItem(new Menu("기네스와퍼", "기네스번과 기네스 바베큐 소스의 압도적인 풍미"));
        myMenu.addItem(new Menu("몬스터와퍼", "불맛 가득 순쇠고기, 치킨, 베이컨에 화끈한 디아블로 소스의 압도적인 맛"));
        myMenu.addItem(new Menu("콰트로치즈와퍼", "4가지 치즈가 불맛에 녹아들어 계속되는 꽉 들어찬 맛"));
        myMenu.addItem(new Menu("트리플머쉬룸와퍼", "트러플 크림소스와 네 가지 머쉬룸이 선사하는 깊고 풍부한 맛의 향연"));
        myMenu.addItem(new Menu("통새우와퍼", "탱글한 통새우, 스파이시 토마토 소스의 조화 새우의 자존심을 세우다"));
        myMenu.addItem(new Menu("너겟킹 8조각", "바삭~ 촉촉~ 한입에 쏙 부드러운 너겟킹"));
        myMenu.addItem(new Menu("치즈프라이", "바싹한 프렌치프라이에 고소한 치즈가 듬뿍!"));
        myMenu.addItem(new Menu("크리미모짜볼", "겉은 바삭 속은 부드러운 달콤짭짤 크림치즈"));
        myMenu.addItem(new Menu("치즈스틱", "치즈가 쭈욱 늘어나는 21cm 초대형 치즈스틱"));
        myMenu.addItem(new Menu("코코넛쉬림프", "통통한 통새우에 바삭하고 고소한 코코넛 식감을 더하다"));
        myMenu.addItem(new Menu("제로콜라R", "햄버거를 피할수 없다면 콜라로 죄책감을 덜자"));
        myMenu.addItem(new Menu("아메리카노", "아아를 한잔도 마시지 않고 살 수 있는 현대인이 있나요?"));
        myMenu.addItem(new Menu("환타오렌지R", "탄산이 필요한 순간! 시원하게 마시자!"));
        myMenu.addItem(new Menu("핫초코", "겨울에 따뜻하고 달달한 핫초코 한잔 할래용~?"));
        myMenu.addItem(new Menu("미닛메이드", "항상 버거킹에 있는 과일 음료수 미닛메이드 오렌지"));
        ArrayList<Menu> items = myMenu.getItems();
        myMenu.showMenus();
        for (Menu item : myMenu.getMainItems()) {
            System.out.println(item.name + " - " + item.desc);}}}