package observer;

public class EmailSubscriber implements Subscriber{

    private String email;

    public EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void update(String news) {
        System.out.println("Enviando a noticia " + news + " para o " + this.email);
    }
}
