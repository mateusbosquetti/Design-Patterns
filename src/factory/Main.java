package factory;

public class Main {
    public static void main(String[] args) {

        Document document = DocumentFactory.createDocument("WORD");
        document.open();

    }
}
