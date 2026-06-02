package decorator;

public class SimpleCoffe implements Coffe{

    public SimpleCoffe() {
    }

    @Override
    public String getDescription() {
        return "Café";
    }

    @Override
    public double getCost() {
        return 5.00;
    }

}
