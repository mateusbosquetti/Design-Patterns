package adapter;

public class LegacySMSProvider {
    public void sendSMS (String phone, String message) {
        System.out.println("Mandando SMS para " + phone + ". Conteudo: " + message);
    }
}
