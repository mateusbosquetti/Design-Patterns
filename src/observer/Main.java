package observer;

public class Main {
    public static void main(String[] args) {
        EmailSubscriber email1 = new EmailSubscriber("mateushb123@gmail.com");
        EmailSubscriber email2 = new EmailSubscriber("teste123@gmail.com");

        NewsLetter newsLetter = new NewsLetter();
        newsLetter.subscribe(email1);
        newsLetter.subscribe(email2);


        newsLetter.addNews("IPHONE 17 PRO MAX com 80% de desconto!");

    }
}
