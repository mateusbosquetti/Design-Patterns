package decorator;

public class MilkDecorator extends CoffeDecorator  {

    public MilkDecorator(Coffe coffe) {
        super(coffe);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " com leite";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.50;
    }
}
