package factory;

public class DocumentFactory {

    public static Document createDocument(String type) {
        if (type.equalsIgnoreCase("PDF")) {
            return new PDFDocument();
        } else if (type.equalsIgnoreCase("WORD")) {
            return new WordDocument();
        }
        throw new IllegalArgumentException("Tipo de documento desconhecido");
    }

}
