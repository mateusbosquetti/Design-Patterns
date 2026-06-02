package singleton;

public class Main {
    public static void main(String[] args) {

        ConfigurationManager c1 = ConfigurationManager.getInstace();
        ConfigurationManager c2 = ConfigurationManager.getInstace();

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());

    }
}
