package key0;
public class goods extends Menus {
    public goods() {
        super();
        map.get("main").get(0).price = 8500;
        map.get("main").get(1).price = 7500;
        map.get("main").get(2).price = 8000;
        map.get("main").get(3).price = 9000;
        map.get("main").get(4).price = 7000;
        map.get("sub").get(0).price = 2000;
        map.get("sub").get(1).price = 3500;
        map.get("sub").get(2).price = 3000;
        map.get("sub").get(3).price = 2500;
        map.get("sub").get(4).price = 4000;
        map.get("beverage").get(0).price = 2000;
        map.get("beverage").get(1).price = 2500;
        map.get("beverage").get(2).price = 2500;
        map.get("beverage").get(3).price = 3000;
        map.get("beverage").get(4).price = 3500;}
    public int getMainPrice(int index) {
        return (int) map.get("main").get((int) index).price;}
    public int getSubPrice(int index) {
        return (int) map.get("sub").get((int) index).price;
    }
    public int getBeveragePrice(int index) {
        return (int) map.get("beverage").get((int) index).price;
    }}
