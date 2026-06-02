package singleton;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private String serverURL;

    private ConfigurationManager() {
        this.serverURL = "http://localhost:8081/api";
        System.out.println("Config carregada");
    }

    public static synchronized ConfigurationManager getInstace() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getServerURL() {
        return serverURL;
    }
}
