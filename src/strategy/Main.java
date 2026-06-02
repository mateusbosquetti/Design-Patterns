package strategy;

public class Main {
    public static void main(String[] args) {
        // Começamos com Pix
        Order order = new Order(new PixPayment());
        order.checkout(100);

        // O usuário mudou de ideia e quer pagar com Cartão
        System.out.println("--- Usuário alterou o método de pagamento ---");
        order.setPaymentStrategy(new CreditCardPayment());
        order.checkout(100);
    }
}
