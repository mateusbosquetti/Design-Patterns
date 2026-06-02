package strategy;

public class PixPayment implements PaymentStrategy{

    @Override
    public void processPayment(double amount) {
        System.out.println("Processando via PIX");
    }
}
