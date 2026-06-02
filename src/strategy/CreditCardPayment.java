package strategy;

public class CreditCardPayment implements PaymentStrategy{

    @Override
    public void processPayment(double amount) {
        System.out.println("Processando via Cartão de Crédito");
    }
}
