package strategy;

public class Order {

    private PaymentStrategy strategy;

    public Order(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout (double amount) {
        strategy.processPayment(amount);
    }

}
