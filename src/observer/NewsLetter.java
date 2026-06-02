package observer;

import java.util.ArrayList;
import java.util.List;

public class NewsLetter {

    private List<Subscriber> subscribers;

    public NewsLetter() {
        this.subscribers = new ArrayList<>();
    }

    public void subscribe(Subscriber s) {
        this.subscribers.add(s);
    }

    public void unsubscribe(Subscriber s) {
        this.subscribers.remove(s);
    }

    public void addNews(String news) {
        for (Subscriber s : this.subscribers) {
            s.update(news);
        }
    }


}
