package builder;

public class Main {
    public static void main(String[] args) {
        House myHouse = new House.HouseBuilder().setColor("White").setWalls(4).build();
        House friendHouse = new House.HouseBuilder().setColor("Red").setWalls(9).setWindows(2).build();

        System.out.println("My house: " + myHouse);
        System.out.println("Friend house: " + friendHouse);
    }
}
