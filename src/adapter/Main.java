package adapter;

public class Main {
    public static void main(String[] args) {

        LegacySMSProvider legacySMSProvider = new LegacySMSProvider();

        SMSAdapter adapter = new SMSAdapter(legacySMSProvider, "47999321041");
        adapter.send("Olá mateus!");
    }
}
