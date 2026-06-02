package adapter;

public class SMSAdapter implements NotificationService{

    private LegacySMSProvider provider;
    private String phone;

    public SMSAdapter(LegacySMSProvider provider, String phone) {
        this.provider = provider;
        this.phone = phone;
    }

    @Override
    public void send(String message) {
        this.provider.sendSMS(this.phone, message);
    }
}
