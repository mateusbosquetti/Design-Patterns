package decorator;

public class Main {
    public static void main(String[] args) {
        Coffe coffe = new SimpleCoffe();
        System.out.println(coffe.getDescription());
        System.out.println(coffe.getCost());
        coffe = new MilkDecorator(coffe);
        System.out.println(coffe.getDescription());
        System.out.println(coffe.getCost());
    }
}
